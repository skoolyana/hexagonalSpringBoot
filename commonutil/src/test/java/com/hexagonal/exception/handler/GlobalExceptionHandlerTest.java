package com.hexagonal.exception.handler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.hexagonal.exception.pricing.InvalidRequestException;
import com.hexagonal.exception.pricing.PricingNotFoundException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Mock
    private PricingNotFoundException pricingNotFoundException;

    @Mock
    private InvalidRequestException invalidRequestException;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHandlePricingNotFoundException() {
        String errorMessage = "Pricing not found.";
        when(pricingNotFoundException.getMessage()).thenReturn(errorMessage);

        ResponseEntity<String> responseEntity = globalExceptionHandler.handlePricingNotFoundException(pricingNotFoundException);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(errorMessage, responseEntity.getBody());

        verify(pricingNotFoundException, times(1)).getMessage();
    }

    @Test
    public void testHandleInvalidRequestException() {
        String errorMessage = "Invalid request.";
        when(invalidRequestException.getMessage()).thenReturn(errorMessage);

        ResponseEntity<String> responseEntity = globalExceptionHandler.handleInvalidRequestException(invalidRequestException);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals(errorMessage, responseEntity.getBody());

        verify(invalidRequestException, times(1)).getMessage();
    }

    @Test
    public void testHandleGenericException() {
        String errorMessage = "An unexpected error occurred.";
        Exception exception = new Exception(errorMessage);

        ResponseEntity<String> responseEntity = globalExceptionHandler.handleGenericException(exception);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals(errorMessage, responseEntity.getBody());
    }
}
