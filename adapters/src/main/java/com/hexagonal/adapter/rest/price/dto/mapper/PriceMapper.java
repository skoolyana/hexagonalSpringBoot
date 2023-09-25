package com.hexagonal.adapter.rest.price.dto.mapper;

import org.mapstruct.Mapper;

import com.hexagonal.adapter.rest.price.dto.PriceDto;
import com.hexagonal.domain.model.price.PriceDomainModel;

@Mapper(componentModel = "spring")
public interface PriceMapper {
	  
	    PriceDto toDto(PriceDomainModel priceDomainModel);

}
