package com.isaachome.ecom.kafka;

import com.isaachome.ecom.customer.CustomerResponse;
import com.isaachome.ecom.payment.PaymentMethod;
import com.isaachome.ecom.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
