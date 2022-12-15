package com.helmes.cities.adapter.in.mapper;

import com.helmes.cities.adapter.in.dto.CityDto;
import com.helmes.cities.adapter.in.dto.CityResponseDto;
import com.helmes.cities.domain.entities.City;

public class CityResponseDtoMapper {
  public static CityResponseDto toCityResponseDto(City city) {
    return new CityResponseDto(city.getId(), city.getName(), city.getPhotoUrl());
  }

  public static City toCity(CityDto city) {
    return new City(city.getId(), city.getName(), city.getPhotoUrl());
  }

}
