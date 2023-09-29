package com.hexagonal.adapter.jpa.price.entity;

import java.time.LocalDateTime;


public class PriceEntityObjectMother {
	
	public static PriceEntity ANY_PRICE_Entity = createAnyPriceEntity().build();


    public static PriceEntity.Builder createAnyPriceEntity() {
        LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59, 59);
        
        return PriceEntity.builder()
            .brandId(1L)
            .startDate(startDate)
            .endDate(endDate)
            .priceList(1)
            .productId(35455L)
            .priority(0)
            .price(35.50)
            .currency("EUR");
    }
    
    public static PriceEntity.Builder createDefaultPriceEntity() {
        LocalDateTime startDate = null; // Set your default start date here
        LocalDateTime endDate = null; // Set your default end date here

        return PriceEntity.builder()
                .brandId(1L)
                .startDate(startDate)
                .endDate(endDate)
                .priceList(null) // Set your default price list here
                .productId(null) // Set your default product ID here
                .priority(null) // Set your default priority here
                .price(null) // Set your default price here
                .currency(null); // Set your default currency here
    }

}
