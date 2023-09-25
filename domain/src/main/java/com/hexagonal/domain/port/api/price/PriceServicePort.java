package com.hexagonal.domain.port.api.price;

import java.time.LocalDateTime;

import com.hexagonal.domain.model.price.PriceDomainModel;

public interface PriceServicePort {

    PriceDomainModel findPriceByBrandAndProductAndDate(Long brandId,
            Long productId, LocalDateTime date);
}
