package com.helmes.cities.adapter.in.mapper;

import com.helmes.cities.adapter.in.dto.CityDto;
import com.helmes.cities.adapter.in.dto.CityResponseDto;
import com.helmes.cities.adapter.in.dto.CityResponseDtoList;
import com.helmes.cities.domain.entities.City;
import java.util.List;
import java.util.stream.Collectors;

public class CityResponseDtoMapper {
  public static CityResponseDto toCityResponseDto(City city) {
    return new CityResponseDto(city.getId(), city.getName(), city.getPhotoUrl());
  }

  public static City toCity(CityDto city) {
    return new City(city.getId(), city.getName(), city.getPhotoUrl());
  }

  public static CityResponseDtoList toCityResponseDtoList(List<City> allCities) {
    return new CityResponseDtoList(allCities.stream()
        .map(CityResponseDtoMapper::toCityResponseDto)
        .collect(Collectors.toList()));
  }

}
