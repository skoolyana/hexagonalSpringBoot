package com.hexagonal.adapter.rest.price.dto.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.hexagonal.adapter.rest.price.dto.PriceDto;
import com.hexagonal.domain.model.price.PriceDomainModel;
import com.hexagonal.domain.model.price.PriceDomainModelObjectMother;

public class PriceMapperTest {
	
	private PriceMapper priceMapper = new PriceMapperImpl(); // Create an instance of the mapper

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    
    @Test
    public void testToDto() {

    	PriceDomainModel priceDomainModel = PriceDomainModelObjectMother.ANY_PRICE;

        PriceDto result = priceMapper.toDto(priceDomainModel);

        PriceDto expected = createExpectedDto();

        assertThat(result).isEqualTo(expected);
    }
    
    
    private PriceDto createExpectedDto() {
        return PriceDto.builder()
                .productId(35455L)
                .brandId("1")
                .priceList(1)
                .startDate(PriceDomainModelObjectMother.ANY_PRICE.getStartDate())
                .endDate(PriceDomainModelObjectMother.ANY_PRICE.getEndDate())
                .price(35.50)
                .currency("EUR")
                .build();
    }
    
    
    
}
