package com.hexagonal.domain.port.spi.price;

import java.time.LocalDateTime;

import com.hexagonal.domain.model.price.PriceDomainModel;

/**
 * Secondary port is used to manage price on persistence level
 */

public interface PriceJpaPort {
	
    PriceDomainModel findPriceByBrandAndProductAndDate(Long brandId, Long productId, 
    		LocalDateTime date);

}