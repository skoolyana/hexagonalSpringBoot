package com.hexagonal.adapter.rest.price.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.hexagonal.adapter.rest.price.dto.PriceDto;
import com.hexagonal.domain.model.price.PriceDomainModel;

@Mapper(componentModel = "spring")
public interface PriceMapper {
	
	  	@Mapping(source = "productId", target = "productId")
	    @Mapping(source = "brandId", target = "brandId")
	    @Mapping(source = "priceList", target = "priceList")
	    @Mapping(source = "startDate", target = "startDate")
	    @Mapping(source = "endDate", target = "endDate")
	    @Mapping(source = "price", target = "price")
	    PriceDto toDto(PriceDomainModel priceDomainModel);

}
