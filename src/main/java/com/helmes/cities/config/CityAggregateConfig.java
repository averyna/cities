package com.helmes.cities.config;

import com.helmes.cities.domain.CityAggregate;
import com.helmes.cities.domain.DefaultCityAggregate;
import com.helmes.cities.domain.repository.CityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CityAggregateConfig {

  @Bean
  public CityAggregate cityAggregate(CityRepository repository) {
    return new DefaultCityAggregate(repository);
  }

}
