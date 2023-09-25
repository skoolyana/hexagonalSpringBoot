package com.hexagonal.adapter.rest.price.dto;

import java.time.LocalDateTime;

public class PriceDtoObjectMother {
	
	public static PriceDto Any_Price_Dto = createDefaultPriceDto().build();
		
	public static PriceDto.PriceDtoBuilder createDefaultPriceDto() {
        LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0); // Use a specific start date
        LocalDateTime endDate = LocalDateTime.of(2023, 1, 31, 23, 59, 59); // Use a specific end date

        return PriceDto.builder()
            .productId(35455L)
            .brandId("1")
            .priceList(1)
            .startDate(startDate)
            .endDate(endDate)
            .price(35.50)
            .currency("EUR");
    }

}
