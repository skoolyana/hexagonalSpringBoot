package com.hexagonal.adapter.rest.price;

import java.time.LocalDateTime;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hexagonal.adapter.rest.price.dto.PriceDto;
import com.hexagonal.adapter.rest.price.dto.mapper.PriceMapper;
import com.hexagonal.domain.model.price.PriceDomainModel;
import com.hexagonal.domain.port.api.price.PriceServicePort;
import com.hexagonal.exception.pricing.InvalidRequestException;

import lombok.RequiredArgsConstructor;

@RestController
@Validated
@RequiredArgsConstructor
public class PriceController {

    private final PriceServicePort priceServicePort;

    private final PriceMapper priceMapper;

    @GetMapping("/prices")
    public PriceDto calculatePrice(
            @RequestParam Long brandId,
            @RequestParam Long productId,
            @RequestParam String dateString) {

        LocalDateTime date;

        try {
            date = LocalDateTime.parse(dateString);
        } catch (Exception e) {
            throw new InvalidRequestException("Invalid date format. Please provide a valid date.");
        }

        // Call the PriceServicePort to calculate the price
        PriceDomainModel priceDomainModel = priceServicePort.findPriceByBrandAndProductAndDate(brandId, productId, date);

        PriceDto response = priceMapper.toDto(priceDomainModel);

        return response;
    }
}
