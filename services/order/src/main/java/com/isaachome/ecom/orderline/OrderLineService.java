package com.isaachome.ecom.orderline;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository repository;
    private final  OrderLineMapper mapper;
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var orderLine = mapper.mapToOrderLine(orderLineRequest);
        return repository.save(orderLine).getId();
    }
}
