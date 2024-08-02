package com.isaachome.ecom.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull(message = "Please min a product is required")
        Integer productId,
        @Positive(message = "Quantity is mandatory")
        double quantity
) {
}
