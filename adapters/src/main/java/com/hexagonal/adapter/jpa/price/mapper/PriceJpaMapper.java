package com.hexagonal.adapter.jpa.price.mapper;

import org.mapstruct.Mapper;

import com.hexagonal.adapter.jpa.price.entity.PriceEntity;
import com.hexagonal.domain.model.price.PriceDomainModel;
import static org.mapstruct.factory.Mappers.getMapper;


@Mapper(componentModel = "spring")
public interface PriceJpaMapper {

	PriceJpaMapper PRICE_JPA_MAPPER = getMapper(PriceJpaMapper.class);

    PriceDomainModel toDomainModel(PriceEntity productEntity);

}