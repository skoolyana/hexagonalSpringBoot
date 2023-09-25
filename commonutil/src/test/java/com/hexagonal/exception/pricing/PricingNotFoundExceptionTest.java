package com.hexagonal.exception.pricing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingNotFoundExceptionTest {

    @Test
    public void testConstructorAndGetMessage() {
        String errorMessage = "Pricing not found message";
        PricingNotFoundException exception = new PricingNotFoundException(errorMessage);

        assertEquals(errorMessage, exception.getMessage());
    }
}