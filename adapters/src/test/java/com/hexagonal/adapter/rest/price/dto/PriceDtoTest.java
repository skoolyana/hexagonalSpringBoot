package com.hexagonal.adapter.rest.price.dto;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriceDtoTest {

    @Test
    public void testNoArgsConstructor() {
        PriceDto priceDto = new PriceDto();
        assertNotNull(priceDto);
    }

    @Test
    public void testAllArgsConstructor() {
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = LocalDateTime.now().plusHours(1);

        PriceDto priceDto = new PriceDto(
            123L, "BrandName", 1, startDate, endDate, 45.67, "USD"
        );

        assertNotNull(priceDto);
        assertEquals(123L, priceDto.getProductId());
        assertEquals("BrandName", priceDto.getBrandId());
        assertEquals(1, priceDto.getPriceList());
        assertEquals(startDate, priceDto.getStartDate());
        assertEquals(endDate, priceDto.getEndDate());
        assertEquals(45.67, priceDto.getPrice());
        assertEquals("USD", priceDto.getCurrency());
    }

    @Test
    public void testEqualsAndHashCode() {
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = LocalDateTime.now().plusHours(1);

        PriceDto priceDto1 = new PriceDto(
            123L, "BrandName", 1, startDate, endDate, 45.67, "USD"
        );

        PriceDto priceDto2 = new PriceDto(
            123L, "BrandName", 1, startDate, endDate, 45.67, "USD"
        );

        assertEquals(priceDto1, priceDto2);
        assertEquals(priceDto1.hashCode(), priceDto2.hashCode());
    }

    @Test
    public void testToString() {
        LocalDateTime startDate = LocalDateTime.now();
        LocalDateTime endDate = LocalDateTime.now().plusHours(1);

        PriceDto priceDto = new PriceDto(
            123L, "BrandName", 1, startDate, endDate, 45.67, "USD"
        );

        String expectedToString = "PriceDto(productId=123, brandId=BrandName, priceList=1, " +
            "startDate=" + startDate + ", endDate=" + endDate + ", price=45.67, currency=USD)";
        assertEquals(expectedToString, priceDto.toString());
    }
}
