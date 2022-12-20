package com.helmes.cities.domain.repository;

import com.helmes.cities.domain.entities.City;
import java.util.List;

public interface CityRepository {

  public List<City> findAllCities();

  public City searchByName(String name);

  public City searchById(String id);

  public City update(City city);

}
