package com.isaachome.ecom.payment;

import com.isaachome.ecom.customer.CustomerResponse;
import com.isaachome.ecom.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
