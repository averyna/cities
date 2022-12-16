package com.helmes.cities.config;

import com.helmes.cities.adapter.out.persistance.MongoCityRepository;
import com.helmes.cities.adapter.out.repository.OutCityRepository;
import com.helmes.cities.domain.repository.CityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

@Repository
public class CityRepositoryConfig {

  @Bean
  public CityRepository cityRepository(MongoCityRepository repository) {
    return new OutCityRepository(repository);
  }

}
