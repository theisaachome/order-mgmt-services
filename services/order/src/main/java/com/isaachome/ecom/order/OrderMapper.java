package com.isaachome.ecom.order;

import lombok.Builder;
import org.springframework.stereotype.Service;

@Service
@Builder
public class OrderMapper {

    public Order toOrderEntity(OrderRequest request){
        return Order.builder()
                .id(request.id())
                .reference(request.reference())
                .customerId(request.customerId())
                .paymentMethod(request.paymentMethod())
                .totalAmount(request.amount())
                .build();
    }
}
