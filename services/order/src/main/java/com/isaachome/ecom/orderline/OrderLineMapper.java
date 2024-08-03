package com.isaachome.ecom.orderline;

import com.isaachome.ecom.order.Order;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Builder
public class OrderLineMapper {
    public OrderLine mapToOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.id())
                .productId(request.productId())
                .quantity(request.quantity())
                .order(Order.builder().id(request.orderId()).build())
                .build();
    }
}
