package com.isaachome.ecom.kafka;

import com.isaachome.ecom.config.KafkaOrderTopicConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class OrderProducer {

    private final KafkaTemplate<String, OrderConfirmation> kafkaTemplate;
    public  void sendOrderConfirmation(OrderConfirmation orderConfirmation){
        log.info("Sending OrderConfirmation: {}", orderConfirmation);
        Message<OrderConfirmation> message = MessageBuilder
                .withPayload(orderConfirmation)
                .setHeader(KafkaHeaders.TOPIC,"order-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
