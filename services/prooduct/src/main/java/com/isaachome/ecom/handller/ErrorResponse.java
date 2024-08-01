package com.isaachome.ecom.handller;

import java.util.Map;

public record ErrorResponse (Map<String,String> errors) {}
