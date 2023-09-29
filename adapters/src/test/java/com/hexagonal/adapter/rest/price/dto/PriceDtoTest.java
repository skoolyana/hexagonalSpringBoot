package com.hexagonal.adapter.rest.price.dto;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriceDtoTest {

    @Test
    public void testNoArgsConstructor() {
        PriceDto priceDto = PriceDtoObjectMother.createDefaultPriceDto().build();
        assertNotNull(priceDto);
    }

    @Test
    public void testAllArgsConstructor() {
       
    	LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59, 59);

    	
    	PriceDto priceDto = PriceDtoObjectMother.createAnyPriceDto().build();


        assertNotNull(priceDto);
        assertEquals(35455L, priceDto.getProductId());
        assertEquals("1", priceDto.getBrandId());
        assertEquals(1, priceDto.getPriceList());
        assertEquals(startDate, priceDto.getStartDate());
        assertEquals(endDate, priceDto.getEndDate());
        assertEquals(35.50, priceDto.getPrice());
        assertEquals("EUR", priceDto.getCurrency());
    }
    
    
    @Test
    public void testPriceDtoWithNullValues() {
        PriceDto priceDto = PriceDtoObjectMother.createDefaultPriceDto().build();
        assertNull(priceDto.getProductId());
        assertNull(priceDto.getBrandId());
        assertNull(priceDto.getStartDate());
        assertNull(priceDto.getEndDate());
        assertNull(priceDto.getCurrency());
    }

    
    
    @Test
    public void testPriceDtoBuilder() {
    	LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59, 59);

        PriceDto priceDto = PriceDtoObjectMother.createAnyPriceDto()
                .productId(123L)
                .brandId("BrandName")
                .priceList(2)
                .startDate(startDate)
                .endDate(endDate)
                .price(45.67)
                .currency("USD")
                .build();

        assertNotNull(priceDto);
        assertEquals(123L, priceDto.getProductId());
        assertEquals("BrandName", priceDto.getBrandId());
        assertEquals(2, priceDto.getPriceList());
        assertEquals(startDate, priceDto.getStartDate());
        assertEquals(endDate, priceDto.getEndDate());
        assertEquals(45.67, priceDto.getPrice());
        assertEquals("USD", priceDto.getCurrency());

    }
    
    
    
    @Test
    public void testPriceDtoBuilderWithNullValues() {
    	PriceDto priceDto = PriceDtoObjectMother.createDefaultPriceDto().build();

        assertNotNull(priceDto);
        assertNull(priceDto.getProductId());
        assertNull(priceDto.getBrandId());
        assertNull(priceDto.getPriceList());
        assertNull(priceDto.getStartDate());
        assertNull(priceDto.getEndDate());
        assertNull(priceDto.getPrice());
        assertNull(priceDto.getCurrency());
    }

    @Test
    public void testEqualsAndHashCode() {
    	PriceDto priceDto1 = PriceDtoObjectMother.createAnyPriceDto().build();
        PriceDto priceDto2 = PriceDtoObjectMother.createAnyPriceDto().build();

        assertEquals(priceDto1, priceDto2);
        assertEquals(priceDto1.hashCode(), priceDto2.hashCode());
    }

    @Test
    public void testToString() {
    	LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59, 59);

        PriceDto priceDto = PriceDtoObjectMother.createAnyPriceDto()
                .productId(123L)
                .brandId("BrandName")
                .priceList(2)
                .startDate(startDate)
                .endDate(endDate)
                .price(45.67)
                .currency("USD")
                .build();

        String expectedToString = "PriceDto(productId=123, brandId=BrandName, priceList=2, " +
            "startDate=2023-01-01T00:00, endDate=2023-01-31T23:59:59, price=45.67, currency=USD)";
        assertEquals(expectedToString, priceDto.toString());
    }
}
