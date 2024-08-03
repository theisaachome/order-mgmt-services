package com.isaachome.ecom.orderline;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {
    private final OrderLineService orderLineService;
    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderLineResponse>> getAllByOrderId(@PathVariable("order-id") Integer orderLineId){
        return ResponseEntity.ok(orderLineService.findAllByOrderId(orderLineId));
    }
}
