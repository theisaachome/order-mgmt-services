package com.isaachome.ecom.handller;

import com.isaachome.ecom.exception.CustomerNotFoundException;
import com.isaachome.ecom.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handle(CustomerNotFoundException exp){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exp.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exp){
        var errors = new HashMap<String, String>();
        exp.getBindingResult()
                .getAllErrors()
                .forEach(objectError -> {
                    var fieldName = ((FieldError)objectError).getField();
                    var errorMessage = objectError.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(errors));
    }
}
