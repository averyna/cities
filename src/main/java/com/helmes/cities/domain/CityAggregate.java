package com.helmes.cities.domain;

import com.helmes.cities.domain.entities.City;
import java.util.List;

public interface CityAggregate {

  public List<City> findAllCities();

  public City findCityByName(String name);

  public City findCityById(String name);

  public City editCity(City city);
}
