package com.hexagonal.application.service.pricing;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.hexagonal.domain.model.price.PriceDomainModel;
import com.hexagonal.domain.port.api.price.PriceServicePort;
import com.hexagonal.domain.port.spi.price.PriceJpaPort;
import com.hexagonal.exception.pricing.PricingNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PricingService implements PriceServicePort {
    private final PriceJpaPort priceJpaPort;

    @Override
    public PriceDomainModel findPriceByBrandAndProductAndDate(Long brandId, Long productId, LocalDateTime date) {

        PriceDomainModel price = priceJpaPort.findPriceByBrandAndProductAndDate(brandId, productId, date);

        if (price == null) {
            throw new PricingNotFoundException("Price not found for the given criteria.");
        }

        return price;
    }
}
