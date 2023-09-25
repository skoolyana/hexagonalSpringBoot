package com.hexagonal.application.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hexagonal.App;
import com.hexagonal.adapter.rest.price.dto.PriceDto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PriceIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private String formattedDate;

    @BeforeEach
    public void setUp() {
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 14, 10, 0);
        formattedDate = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    @Test
    public void testRequestAt10AMOn14th() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("dateString", formattedDate)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();

        PriceDto priceDto = objectMapper.readValue(responseContent, PriceDto.class);

        assertThat(priceDto.getProductId()).isEqualTo(35455L);
        assertThat(priceDto.getBrandId()).isEqualTo("1");
        assertThat(priceDto.getPriceList()).isEqualTo(1);

        assertThat(priceDto.getPrice()).isEqualTo(35.50);
    }

    @Test
    public void testRequestAt4PMOn14th() throws Exception {
        // Create a date and time for 4 PM on the 14th
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 14, 16, 0);
        String formattedDate = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("dateString", formattedDate)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        
        // Now, you can assert specific values in the response JSON
        String responseContent = result.getResponse().getContentAsString();
        
        // Assuming you have a class to map the JSON response, e.g., PriceDto
        PriceDto priceDto = objectMapper.readValue(responseContent, PriceDto.class);

     // Add your assertions here, for example:
        assertThat(priceDto.getProductId()).isEqualTo(35455L);
        assertThat(priceDto.getBrandId()).isEqualTo("1");
        assertThat(priceDto.getPriceList()).isEqualTo(2);
    
        assertThat(priceDto.getPrice()).isEqualTo(25.45);

    
    }

    @Test
    public void testRequestAt9PMOn14th() throws Exception {
        // Create a date and time for 9 PM on the 14th
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 14, 21, 0);
        String formattedDate = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("dateString", formattedDate)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

     // Now, you can assert specific values in the response JSON
        String responseContent = result.getResponse().getContentAsString();

        // Assuming you have a class to map the JSON response, e.g., PriceDto
        PriceDto priceDto = objectMapper.readValue(responseContent, PriceDto.class);

        // Add your assertions here, for example:
        assertThat(priceDto.getProductId()).isEqualTo(35455L);
        assertThat(priceDto.getBrandId()).isEqualTo("1");
        assertThat(priceDto.getPriceList()).isEqualTo(1);

        assertThat(priceDto.getPrice()).isEqualTo(35.50);
        
        
    }

    @Test
    public void testRequestAt10AMOn15th() throws Exception {
        // Create a date and time for 10 AM on the 15th
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 15, 10, 0);
        String formattedDate = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("dateString", formattedDate)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        
        String responseContent = result.getResponse().getContentAsString();

        PriceDto priceDto = objectMapper.readValue(responseContent, PriceDto.class);

        assertThat(priceDto.getProductId()).isEqualTo(35455L);
        assertThat(priceDto.getBrandId()).isEqualTo("1");
        assertThat(priceDto.getPriceList()).isEqualTo(3);

        assertThat(priceDto.getPrice()).isEqualTo(30.50);
    }


    

    @Test
    public void testRequestAt9PMOn16th() throws Exception {
        // Create a date and time for 9 PM on the 16th
        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 16, 21, 0);
        String formattedDate = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                .param("brandId", "1")
                .param("productId", "35455")
                .param("dateString", formattedDate)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        String responseContent = result.getResponse().getContentAsString();

        PriceDto priceDto = objectMapper.readValue(responseContent, PriceDto.class);

        assertThat(priceDto.getProductId()).isEqualTo(35455L);
        assertThat(priceDto.getBrandId()).isEqualTo("1");
        assertThat(priceDto.getPriceList()).isEqualTo(4);

        assertThat(priceDto.getPrice()).isEqualTo(38.95);
        
    }
}

