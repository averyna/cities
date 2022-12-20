package com.helmes.cities.config;

import com.helmes.cities.adapter.in.CityController;
import com.helmes.cities.adapter.in.CityRestService;
import com.helmes.cities.domain.CityAggregate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CitiesControllerConfig {

  @Bean
  public CityController receiverController(final CityAggregate cityAggregate) {
    return new CityRestService(cityAggregate);
  }

}
