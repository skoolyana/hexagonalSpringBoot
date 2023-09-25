package com.hexagonal.exception.pricing;

public class PricingNotFoundException extends RuntimeException {
    public PricingNotFoundException(String message) {
        super(message);
    }
}
