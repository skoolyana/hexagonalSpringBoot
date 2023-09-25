package com.hexagonal.adapter.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@Configuration
@EntityScan("com.hexagonal.adapter.jpa")
@EnableJpaRepositories("com.hexagonal.adapter.jpa")
public class JpaConfig {
}