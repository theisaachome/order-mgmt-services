package com.isaachome.ecom.exception;

import java.util.Map;

public record ErrorResponse (Map<String,String> errors) {
}
