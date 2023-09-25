package com.hexagonal.adapter.rest.price.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PriceDto {
	
	private Long productId;
    private String brandId;
    private Integer priceList;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
    private String currency;
	
}

