package com.helmes.cities.domain;

import com.helmes.cities.domain.entities.City;
import com.helmes.cities.domain.repository.CityRepository;
import java.util.List;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DefaultCityAggregate implements CityAggregate {

  private final CityRepository repository;

  @Override
  public List<City> findAllCities() {
    return repository.findAllCities();
  }

  @Override
  public City findCityByName(String name) {
    return repository.searchByName(name);
  }

  @Override
  public Boolean editCity(City city) {
    return repository.update(city);
  }
}
