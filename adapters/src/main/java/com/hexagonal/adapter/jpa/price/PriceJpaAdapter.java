package com.hexagonal.adapter.jpa.price;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.hexagonal.adapter.jpa.price.entity.PriceEntity;
import com.hexagonal.adapter.jpa.price.mapper.PriceJpaMapper;
import com.hexagonal.adapter.jpa.price.repository.PriceRepository;
import com.hexagonal.domain.model.price.PriceDomainModel;
import com.hexagonal.domain.port.spi.price.PriceJpaPort;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PriceJpaAdapter implements PriceJpaPort {

    private final PriceRepository priceRepository;

    @Override
    public PriceDomainModel findPriceByBrandAndProductAndDate(Long brandId, Long productId, LocalDateTime date) {
        // TODO Auto-generated method stub

        List<PriceEntity> prices = priceRepository.findPricesInRangeOrderedByPriorityDesc(
                brandId, productId, date);

        if (!prices.isEmpty()) {
            return PriceJpaMapper.PRICE_JPA_MAPPER.toDomainModel(prices.get(0));
        }

        return null; // Handle the case when no matching rate is found

    }
}
