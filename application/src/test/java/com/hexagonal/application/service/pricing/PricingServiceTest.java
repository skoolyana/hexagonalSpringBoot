package com.hexagonal.application.service.pricing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.hexagonal.domain.model.price.PriceDomainModel;
import com.hexagonal.domain.model.price.PriceDomainModelObjectMother;
import com.hexagonal.domain.port.spi.price.PriceJpaPort;
import com.hexagonal.exception.pricing.PricingNotFoundException;

public class PricingServiceTest {
	
	@Mock
    private PriceJpaPort priceJpaPort;

    @InjectMocks
    private PricingService pricingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testFindPriceByBrandAndProductAndDate_PriceFound() {

    	PriceDomainModel expectedPrice = PriceDomainModelObjectMother.ANY_PRICE;
        Long brandId = expectedPrice.getBrandId();
        Long productId = expectedPrice.getProductId();
        LocalDateTime date = expectedPrice.getStartDate();

        when(priceJpaPort.findPriceByBrandAndProductAndDate(brandId, productId, date)).thenReturn(expectedPrice);

        PriceDomainModel result = pricingService.findPriceByBrandAndProductAndDate(brandId, productId, date);

        assertEquals(expectedPrice, result);

        verify(priceJpaPort, times(1)).findPriceByBrandAndProductAndDate(brandId, productId, date);
    }
	
    
    
    @Test
    public void testFindPriceByBrandAndProductAndDate_PriceNotFound() {

    	Long brandId = PriceDomainModelObjectMother.ANY_PRICE.getBrandId();
        Long productId = PriceDomainModelObjectMother.ANY_PRICE.getProductId();
        LocalDateTime date = PriceDomainModelObjectMother.ANY_PRICE.getStartDate();

        when(priceJpaPort.findPriceByBrandAndProductAndDate(brandId, productId, date)).thenReturn(null);

        assertThrows(PricingNotFoundException.class, () -> {
            pricingService.findPriceByBrandAndProductAndDate(brandId, productId, date);
        });

        verify(priceJpaPort, times(1)).findPriceByBrandAndProductAndDate(brandId, productId, date);
    }

}
