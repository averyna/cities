package com.helmes.cities.domain;

import com.helmes.cities.domain.entities.City;
import com.helmes.cities.domain.exceptions.CityNotFoundException;
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
    final City city = repository.searchByName(name);
    if (city == null) {
      throw new CityNotFoundException("The city is not found");
    }
    return city;
  }

  @Override
  public City findCityById(String id) {
    final City city = repository.searchById(id);
    if (city == null) {
      throw new CityNotFoundException("The city is not found, id " + id);
    }
    return city;
  }

  @Override
  public City editCity(City city) {
    final City existingCity = repository.searchById(city.getId());
    if (existingCity == null) {
      throw new CityNotFoundException("The city is not found " + city);
    }
    return repository.update(city);
  }
}
