package com.hexagonal.adapter.jpa.price.entity;


import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriceEntityTest {

    @Test
    public void testPriceEntityFields() {

    	LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59, 59);

        PriceEntity priceEntity = PriceEntity.builder()
                .brandId(1L)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(1)
                .productId(123L)
                .priority(1)
                .price(45.67)
                .currency("USD")
                .build();

        assertNotNull(priceEntity);
        assertEquals(1L, priceEntity.getBrandId());
        assertEquals(startDate, priceEntity.getStartDate());
        assertEquals(endDate, priceEntity.getEndDate());
        assertEquals(1, priceEntity.getPriceList());
        assertEquals(123L, priceEntity.getProductId());
        assertEquals(1, priceEntity.getPriority());
        assertEquals(45.67, priceEntity.getPrice());
        assertEquals("USD", priceEntity.getCurrency());
    }
    
    @Test
    public void testEqualsAndHashCode() {
        LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59, 59);

        PriceEntity priceEntity1 = PriceEntity.builder()
                .brandId(1L)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(1)
                .productId(123L)
                .priority(1)
                .price(45.67)
                .currency("USD")
                .build();

        PriceEntity priceEntity2 = PriceEntity.builder()
                .brandId(1L)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(1)
                .productId(123L)
                .priority(1)
                .price(45.67)
                .currency("USD")
                .build();

        assertEquals(priceEntity1, priceEntity2);
        assertEquals(priceEntity1.hashCode(), priceEntity2.hashCode());
    }
    
    @Test
    public void testDefaultValues() {
        PriceEntity priceEntity = PriceEntity.builder()
                .brandId(1L)
                .price(45.67)
                .build();

        assertNotNull(priceEntity);
        assertEquals(null, priceEntity.getPriceList()); // Default value for priceList
        assertNull(priceEntity.getStartDate()); // Default value for startDate
        assertNull(priceEntity.getEndDate()); // Default value for endDate
        assertEquals(null, priceEntity.getPriority()); // Default value for priority
        assertNull(priceEntity.getCurrency()); // Default value for currency
    }


    @Test
    public void testEqualsWithDifferentBrandId() {
        LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59, 59);

        PriceEntity priceEntity1 = PriceEntity.builder()
                .brandId(1L)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(1)
                .productId(123L)
                .priority(1)
                .price(45.67)
                .currency("USD")
                .build();

        PriceEntity priceEntity2 = PriceEntity.builder()
                .brandId(2L) // Different brandId
                .startDate(startDate)
                .endDate(endDate)
                .priceList(1)
                .productId(123L)
                .priority(1)
                .price(45.67)
                .currency("USD")
                .build();

        assertNotEquals(priceEntity1, priceEntity2);
    }

    
    @Test
    public void testDifferentPriorities() {
        LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59, 59);

        PriceEntity highPriorityEntity = PriceEntity.builder()
                .brandId(1L)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(1)
                .productId(123L)
                .priority(1) // High priority
                .price(45.67)
                .currency("USD")
                .build();

        PriceEntity lowPriorityEntity = PriceEntity.builder()
                .brandId(1L)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(1)
                .productId(123L)
                .priority(2) // Low priority
                .price(45.67)
                .currency("USD")
                .build();

        assertEquals(1, highPriorityEntity.getPriority());
        assertEquals(2, lowPriorityEntity.getPriority());
    }

    @Test
    public void testDifferentPriceLists() {
        LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59, 59);

        PriceEntity priceList1Entity = PriceEntity.builder()
                .brandId(1L)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(1)
                .productId(123L)
                .priority(1)
                .price(45.67)
                .currency("USD")
                .build();

        PriceEntity priceList2Entity = PriceEntity.builder()
                .brandId(1L)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(2) // Different price list
                .productId(123L)
                .priority(1)
                .price(45.67)
                .currency("USD")
                .build();

        assertEquals(1, priceList1Entity.getPriceList());
        assertEquals(2, priceList2Entity.getPriceList());
    }

    
    @Test
    public void testCurrencyHandling() {
        LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59, 59);

        PriceEntity usdEntity = PriceEntity.builder()
                .brandId(1L)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(1)
                .productId(123L)
                .priority(1)
                .price(45.67)
                .currency("USD")
                .build();

        PriceEntity euroEntity = PriceEntity.builder()
                .brandId(1L)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(1)
                .productId(123L)
                .priority(1)
                .price(45.67)
                .currency("EUR") // Different currency
                .build();

        assertEquals("USD", usdEntity.getCurrency());
        assertEquals("EUR", euroEntity.getCurrency());
    }
}

