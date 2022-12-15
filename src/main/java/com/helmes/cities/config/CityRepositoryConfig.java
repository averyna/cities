package com.helmes.cities.config;

import com.helmes.cities.adapter.out.repository.PostgresCityRepository;
import com.helmes.cities.domain.repository.CityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepositoryConfig {

  @Bean
  public CityRepository cityRepository() {
    return new PostgresCityRepository();
//  public CityRepository cityRepository() {
//    return new PostgresCityRepository();
  }

}
