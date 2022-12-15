package com.helmes.cities.domain.repository;

import com.helmes.cities.domain.entities.City;
import java.util.List;

public interface CityRepository {

  public List<City> findAllCities();

  public City searchByName(String name);

  public Boolean update(City city);

}
