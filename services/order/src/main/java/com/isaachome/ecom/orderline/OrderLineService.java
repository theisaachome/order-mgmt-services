package com.isaachome.ecom.orderline;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository repository;
    private final  OrderLineMapper mapper;
    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        var orderLine = mapper.mapToOrderLine(orderLineRequest);
        return repository.save(orderLine).getId();
    }

    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
       return repository.findAllByOrderId(orderId)
               .stream()
               .map(mapper::mapToOrderLineResponse)
               .collect(Collectors.toList());
    }
}
