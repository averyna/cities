package com.helmes.cities.adapter.in;

import com.helmes.cities.adapter.in.dto.CityDto;
import com.helmes.cities.adapter.in.dto.CityResponseDto;
import com.helmes.cities.adapter.in.dto.CityResponseDtoList;
import com.helmes.cities.adapter.in.exceptions.RestCityNotFoundException;
import com.helmes.cities.adapter.in.mapper.CityResponseDtoMapper;
import com.helmes.cities.domain.CityAggregate;
import com.helmes.cities.domain.entities.City;
import com.helmes.cities.domain.exceptions.CityNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@Slf4j
public class CityRestService implements CityController {

  private final CityAggregate cityAggregate;

  @Override
  public ResponseEntity<CityResponseDtoList> getAllCities() {
    final List<City> allCities = cityAggregate.findAllCities();
    return ResponseEntity.ok(CityResponseDtoMapper.toCityResponseDtoList(allCities));
  }

  @Override
  public ResponseEntity<CityResponseDto> getCityByName(String name) {
    final City cityByName;
    try {
      cityByName = cityAggregate.findCityByName(name);
    } catch (CityNotFoundException ex) {
    throw new RestCityNotFoundException("Can't find the city by given name " + name, HttpStatus.NOT_FOUND, ex);
  }
    return ResponseEntity.ok(CityResponseDtoMapper.toCityResponseDto(cityByName));
  }

  @Override
  public ResponseEntity<CityResponseDto> editCity(CityDto cityDto, String id) {
    City city;
    try {
      city = cityAggregate.editCity(CityResponseDtoMapper.toCity(cityDto));
    } catch (CityNotFoundException ex) {
      throw new RestCityNotFoundException("Can't find the city to update", HttpStatus.NOT_FOUND, ex);
    }
    return ResponseEntity.ok(CityResponseDtoMapper.toCityResponseDto(city));
  }
}
