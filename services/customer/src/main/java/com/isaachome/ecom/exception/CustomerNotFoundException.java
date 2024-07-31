package com.isaachome.ecom.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class CustomerNotFoundException extends RuntimeException {
    private String message;
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
