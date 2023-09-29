package com.hexagonal.adapter.rest.price;

import com.hexagonal.adapter.rest.price.dto.PriceDto;
import com.hexagonal.adapter.rest.price.dto.PriceDtoObjectMother;
import com.hexagonal.adapter.rest.price.dto.mapper.PriceMapper;
import com.hexagonal.domain.model.price.PriceDomainModel;
import com.hexagonal.domain.model.price.PriceDomainModelObjectMother;
import com.hexagonal.domain.port.api.price.PriceServicePort;
import com.hexagonal.exception.pricing.InvalidRequestException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(value = SpringExtension.class)
@WebMvcTest(controllers = PriceController.class)
@ContextConfiguration(classes = {PriceController.class})

public class PriceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceServicePort priceServicePort;
    
    @MockBean
    private PriceMapper priceMapper;

    @Test
    void calculatePrice_validInput_returnsPriceDto() throws Exception {
    
    	Long brandId = 1L;
        Long productId = 2L;
        String dateString = "2023-09-30T12:00:00";

        LocalDateTime parsedDate = LocalDateTime.parse(dateString);
        
        PriceDto priceDto = PriceDtoObjectMother.Any_Price_Dto;

        PriceDomainModel priceDomainModel = PriceDomainModelObjectMother.ANY_PRICE;
        		
        when(priceServicePort.findPriceByBrandAndProductAndDate(brandId, productId, parsedDate)).thenReturn(priceDomainModel);

        when(priceMapper.toDto(priceDomainModel)).thenReturn(priceDto);
        
        mockMvc.perform(get("/prices")
                .param("brandId", brandId.toString())
                .param("productId", productId.toString())
                .param("dateString", dateString))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.productId").value(priceDomainModel.getProductId()))
                .andExpect(jsonPath("$.price").value(priceDomainModel.getPrice()));
    }
}

