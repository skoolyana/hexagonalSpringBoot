package com.hexagonal.exception.pricing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class InvalidRequestExceptionTest {

    @Test
    public void testConstructorAndGetMessage() {
        String errorMessage = "Invalid request message";
        InvalidRequestException exception = new InvalidRequestException(errorMessage);
        assertEquals(errorMessage, exception.getMessage());
    }
}

