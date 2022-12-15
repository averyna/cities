package com.helmes.cities.adapter.in;

import com.helmes.cities.adapter.in.dto.CityDto;
import com.helmes.cities.adapter.in.dto.CityResponseDto;
import com.helmes.cities.adapter.in.mapper.CityResponseDtoMapper;
import com.helmes.cities.domain.CityAggregate;
import com.helmes.cities.domain.entities.City;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class CitiesRestService implements CitiesController {

  private final CityAggregate cityAggregate;

  @Override
  public List<CityResponseDto> getAllCities() {
    final List<City> allCities = cityAggregate.findAllCities();
    return allCities.stream().map(CityResponseDtoMapper::toCityResponseDto).collect(Collectors.toList());
  }

  @Override
  public CityResponseDto getCityByName(String name) {
    final City cityByName = cityAggregate.findCityByName(name);
    return CityResponseDtoMapper.toCityResponseDto(cityByName);
    // todo: handle request when there is no match by name
  }

  @Override
  public void editCity(CityDto cityDto) {
    final Boolean result = cityAggregate.editCity(CityResponseDtoMapper.toCity(cityDto));
    // todo: manage update operation
  }
}
