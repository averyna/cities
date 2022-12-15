package com.helmes.cities.config;

import com.helmes.cities.adapter.in.CitiesController;
import com.helmes.cities.adapter.in.CitiesRestService;
import com.helmes.cities.domain.CityAggregate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CitiesControllerConfig {

  @Bean
  public CitiesController receiverController(final CityAggregate cityAggregate) {
    return new CitiesRestService(cityAggregate);
  }

}
