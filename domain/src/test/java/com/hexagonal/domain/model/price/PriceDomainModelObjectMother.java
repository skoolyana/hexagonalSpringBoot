package com.hexagonal.domain.model.price;

import java.time.LocalDateTime;

public class PriceDomainModelObjectMother {
	
	
	public static PriceDomainModel ANY_PRICE = createDefaultPrice().build();

	
	public static PriceDomainModel.PriceDomainModelBuilder createDefaultPrice() {
		
		 LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0); // Use a specific start date
		 LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59, 59); // Use a specific end date
		  
		
        return PriceDomainModel.builder()
            .productId(35455L)
            .brandId(1L)
            .priceList(1)
            .startDate(startDate)
            .endDate(endDate)
            .price(35.50)
            .currency("EUR");
            
    }
}
