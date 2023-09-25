package com.hexagonal.adapter.jpa.price.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hexagonal.adapter.jpa.price.entity.PriceEntity;
import com.hexagonal.adapter.jpa.price.entity.PriceEntityObjectMother;
import com.hexagonal.domain.model.price.PriceDomainModel;
import com.hexagonal.domain.model.price.PriceDomainModelObjectMother;

public class PriceJpaMapperTest {
	

	
		@InjectMocks
	    private PriceJpaMapperImpl priceJpaMapper;

	    @Mock
	    private PriceEntity priceEntity;
	    
	    private AutoCloseable closeable;
	    

	    @BeforeEach
	    public void setUp() {
	        closeable = MockitoAnnotations.openMocks(this);
	    }
	    
	    @AfterEach
	    public void tearDown() throws Exception {
	        closeable.close();
	    }
	    
	    
	    @Test
	    public void testToDomainModel() {
	        
	        PriceDomainModel result = priceJpaMapper.toDomainModel(PriceEntityObjectMother.ANY_PRICE_Entity);

	        PriceDomainModel expected = createExpectedModel();
	        
	        assertThat(result).isEqualTo(expected);
	    }

	    private PriceDomainModel createExpectedModel() {
	        return PriceDomainModelObjectMother.ANY_PRICE;
	    }
	

}
