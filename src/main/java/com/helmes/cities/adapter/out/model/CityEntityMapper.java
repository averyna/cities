package com.helmes.cities.adapter.out.model;

import com.helmes.cities.domain.entities.City;

public class CityEntityMapper {

  public static CityEntity toCityEntity(City city) {
    return new CityEntity(city.getId(), city.getName(), city.getPhotoUrl());
  }

  public static City toCity(CityEntity city) {
    return new City(city.getId(), city.getName(), city.getPhoto());
  }
}
