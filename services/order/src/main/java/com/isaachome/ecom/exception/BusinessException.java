package com.isaachome.ecom.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public class BusinessException extends RuntimeException{

    private String message;
    public BusinessException(String message) {
        super(message);
    }
}
