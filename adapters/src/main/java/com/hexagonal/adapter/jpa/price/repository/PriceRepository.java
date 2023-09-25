package com.hexagonal.adapter.jpa.price.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hexagonal.adapter.jpa.price.entity.PriceEntity;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {

    @Query("SELECT p FROM PriceEntity p "
    + "WHERE p.brandId = :brandId "
    + "AND p.productId = :productId "
    + "AND :date BETWEEN p.startDate AND p.endDate "
    + "ORDER BY p.priority DESC")
    List<PriceEntity> findPricesInRangeOrderedByPriorityDesc(
        @Param("brandId") Long brandId,
        @Param("productId") Long productId,
        @Param("date") LocalDateTime date);

}
