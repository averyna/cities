package com.helmes.cities.config;

import com.helmes.cities.adapter.out.helper.CityCSVLoader;
import com.helmes.cities.adapter.out.persistance.MongoCityRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CityCSVLoaderConfig {

  @Bean
  public CityCSVLoader cityCSVLoader(MongoCityRepository repository) {
    final CityCSVLoader loader = new CityCSVLoader(repository);
    loader.loadCsv();
    return loader;
  }

}
