package com.hexagonal.adapter.jpa.price.entity;


import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PriceEntityTest {

    @Test
    public void testPriceEntityFields() {

    	LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59, 59);

        PriceEntity priceEntity = PriceEntityObjectMother.createAnyPriceEntity().build();

        assertNotNull(priceEntity);
        assertEquals(1L, priceEntity.getBrandId());
        // Add assertions for other fields
    }
    
    @Test
    public void testEqualsAndHashCode() {
        
    	PriceEntity priceEntity1 = PriceEntityObjectMother.createAnyPriceEntity().build();
        PriceEntity priceEntity2 = PriceEntityObjectMother.createAnyPriceEntity().build();

        assertEquals(priceEntity1, priceEntity2);
        assertEquals(priceEntity1.hashCode(), priceEntity2.hashCode());
    }
    
    @Test
    public void testDefaultValues() {
        PriceEntity priceEntity = PriceEntityObjectMother.createDefaultPriceEntity().build();


        assertNotNull(priceEntity);
        assertEquals(null, priceEntity.getPriceList()); // Default value for priceList
        assertNull(priceEntity.getStartDate()); // Default value for startDate
        assertNull(priceEntity.getEndDate()); // Default value for endDate
        assertEquals(null, priceEntity.getPriority()); // Default value for priority
        assertNull(priceEntity.getCurrency()); // Default value for currency
    }


    @Test
    public void testEqualsWithDifferentBrandId() {
     
    	PriceEntity priceEntity1 = PriceEntityObjectMother.createAnyPriceEntity().build();

        PriceEntity priceEntity2 = PriceEntityObjectMother.createAnyPriceEntity()
                .brandId(2L) // Different brandId
                .build();

        assertNotEquals(priceEntity1, priceEntity2);
    }

    
    @Test
    public void testDifferentPriorities() {
    	PriceEntity highPriorityEntity = PriceEntityObjectMother.createAnyPriceEntity()
                .priority(1) // High priority
                .build();

        PriceEntity lowPriorityEntity = PriceEntityObjectMother.createAnyPriceEntity()
                .priority(2) // Low priority
                .build();


        assertEquals(1, highPriorityEntity.getPriority());
        assertEquals(2, lowPriorityEntity.getPriority());
    }

    @Test
    public void testDifferentPriceLists() {
    	PriceEntity priceList1Entity = PriceEntityObjectMother.createAnyPriceEntity()
                .priceList(1)
                .build();

        PriceEntity priceList2Entity = PriceEntityObjectMother.createAnyPriceEntity()
                .priceList(2) // Different price list
                .build();


        assertEquals(1, priceList1Entity.getPriceList());
        assertEquals(2, priceList2Entity.getPriceList());
    }

    
    @Test
    public void testCurrencyHandling() {
    	PriceEntity usdEntity = PriceEntityObjectMother.createAnyPriceEntity()
                .currency("USD")
                .build();

        PriceEntity euroEntity = PriceEntityObjectMother.createAnyPriceEntity()
                .currency("EUR") // Different currency
                .build();

        assertEquals("USD", usdEntity.getCurrency());
        assertEquals("EUR", euroEntity.getCurrency());
    }
    
    
    @Test
    public void testDifferentIds() {
        PriceEntity priceEntity1 = PriceEntityObjectMother.createAnyPriceEntity().id(1L).build();
        PriceEntity priceEntity2 = PriceEntityObjectMother.createAnyPriceEntity().id(2L).build();

        assertNotEquals(priceEntity1, priceEntity2);
    }

    @Test
    public void testDifferentStartDates() {
        LocalDateTime startDate1 = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime startDate2 = LocalDateTime.of(2023, 2, 1, 0, 0);

        PriceEntity priceEntity1 = PriceEntityObjectMother.createAnyPriceEntity().startDate(startDate1).build();
        PriceEntity priceEntity2 = PriceEntityObjectMother.createAnyPriceEntity().startDate(startDate2).build();

        assertNotEquals(priceEntity1, priceEntity2);
    }

    @Test
    public void testDifferentEndDates() {
        LocalDateTime endDate1 = LocalDateTime.of(2023, 1, 31, 23, 59, 59);
        LocalDateTime endDate2 = LocalDateTime.of(2023, 2, 28, 23, 59, 59);

        PriceEntity priceEntity1 = PriceEntityObjectMother.createAnyPriceEntity().endDate(endDate1).build();
        PriceEntity priceEntity2 = PriceEntityObjectMother.createAnyPriceEntity().endDate(endDate2).build();

        assertNotEquals(priceEntity1, priceEntity2);
    }

    @Test
    public void testSameIdsAndEqualObjects() {
        PriceEntity priceEntity1 = PriceEntityObjectMother.createAnyPriceEntity().id(1L).build();
        PriceEntity priceEntity2 = PriceEntityObjectMother.createAnyPriceEntity().id(1L).build();

        assertEquals(priceEntity1, priceEntity2);
    }

    @Test
    public void testDifferentObjects() {
        PriceEntity priceEntity = PriceEntityObjectMother.createAnyPriceEntity().build();
        Object nonPriceEntityObject = new Object();

        assertNotEquals(priceEntity, nonPriceEntityObject);
    }
    
    
    
}

