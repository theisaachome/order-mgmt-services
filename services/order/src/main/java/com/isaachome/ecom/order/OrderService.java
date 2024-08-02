package com.isaachome.ecom.order;

import com.isaachome.ecom.customer.CustomerClient;
import com.isaachome.ecom.exception.BusinessException;
import com.isaachome.ecom.product.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    public Integer createOrder(OrderRequest request) {
        //check customer  => openFeign
         var customer = customerClient.getCustomerById(request.customerId())
                 .orElseThrow(() -> new BusinessException("Customer not found with provided ID::" + request.customerId()));
        // purchase product  => call product-service (Use Template)
        this.productClient.getPurchaseProduct(request.products());

        // persist order

        // persist order-line

        // start payment process

        // send order confirmation  -> notification-service (kafka)

        return 0;
    }
}
