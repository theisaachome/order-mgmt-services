package com.isaachome.ecom.order;

import com.isaachome.ecom.customer.CustomerClient;
import com.isaachome.ecom.exception.BusinessException;
import com.isaachome.ecom.kafka.OrderConfirmation;
import com.isaachome.ecom.kafka.OrderProducer;
import com.isaachome.ecom.orderline.OrderLineRequest;
import com.isaachome.ecom.orderline.OrderLineService;
import com.isaachome.ecom.product.ProductClient;
import com.isaachome.ecom.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final  OrderMapper mapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    public Integer createOrder(OrderRequest request) {
        //check customer  => openFeign
         var customer = customerClient.getCustomerById(request.customerId())
                 .orElseThrow(() -> new BusinessException("Customer not found with provided ID::" + request.customerId()));
        // purchase product  => call product-service (Use Template)
       var purchasedProduct=  this.productClient.getPurchaseProduct(request.products());

        // persist order
        var order = repository.save(mapper.toOrderEntity(request));
        // persist order-line
        for(PurchaseRequest purchaseRequest:request.products()) {
            orderLineService.saveOrderLine(new OrderLineRequest(
                    null,
                    order.getId(),
                    purchaseRequest.productId(),
                    purchaseRequest.quantity()
            ));
        }
        //todo start payment process

        // send order confirmation  -> notification-service (kafka)
        orderProducer.sendOrderConfirmation(new OrderConfirmation(
                request.reference(),
                request.amount(),
                request.paymentMethod(),
                customer,
                purchasedProduct
        ));
        return order.getId();
    }

    public List<OrderResponse> getAllOrder() {
        return repository.findAll()
                .stream()
                .map(mapper::toOrderResponse)
                .collect(Collectors.toList());
    }

    public OrderResponse findOrderById(Integer orderId) {
        return repository.findById(orderId)
                .map(mapper::toOrderResponse)
                .orElseThrow(()-> new EntityNotFoundException("Order not found with provided ID::" + orderId));
    }
}
