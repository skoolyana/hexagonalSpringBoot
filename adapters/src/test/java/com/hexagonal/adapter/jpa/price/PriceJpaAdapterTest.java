package com.hexagonal.adapter.jpa.price;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.hexagonal.adapter.jpa.price.entity.PriceEntity;
import com.hexagonal.adapter.jpa.price.entity.PriceEntityObjectMother;
import com.hexagonal.adapter.jpa.price.mapper.PriceJpaMapper;
import com.hexagonal.adapter.jpa.price.repository.PriceRepository;
import com.hexagonal.domain.model.price.PriceDomainModel;

public class PriceJpaAdapterTest {

    @InjectMocks
    private PriceJpaAdapter priceJpaAdapter;

    @Mock
    private PriceRepository priceRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindPriceByBrandAndProductAndDate_PriceFound() {
       
    	PriceEntity mockPriceEntity = PriceEntityObjectMother.ANY_PRICE_Entity;
    	 
        Long brandId = mockPriceEntity.getBrandId();
        Long productId = mockPriceEntity.getProductId();
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);

        List<PriceEntity> priceEntities = new ArrayList<>();
        priceEntities.add(mockPriceEntity);

        when(priceRepository.findPricesInRangeOrderedByPriorityDesc(brandId, productId, date)).
        thenReturn(priceEntities);

        PriceDomainModel result = priceJpaAdapter.findPriceByBrandAndProductAndDate(brandId, productId, date);

        // Verify that the result matches the expected PriceDomainModel
        assertEquals(PriceJpaMapper.PRICE_JPA_MAPPER.toDomainModel(mockPriceEntity), result);

        verify(priceRepository, times(1)).findPricesInRangeOrderedByPriorityDesc(brandId, productId, date);
    }

    @Test
    public void testFindPriceByBrandAndProductAndDate_PriceNotFound() {

    	Long brandId = 1L;
        Long productId = 35455L;
        LocalDateTime date = LocalDateTime.of(2020, 6, 14, 10, 0);

        when(priceRepository.findPricesInRangeOrderedByPriorityDesc(brandId, productId, date)).
        thenReturn(new ArrayList<>());

        PriceDomainModel result = priceJpaAdapter.findPriceByBrandAndProductAndDate(brandId, productId, date);

        assertEquals(null, result);

        verify(priceRepository, times(1)).findPricesInRangeOrderedByPriorityDesc(brandId, productId, date);
    }
}
