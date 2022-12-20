package com.helmes.cities.adapter.in;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.helmes.cities.adapter.in.dto.CityDto;
import com.helmes.cities.adapter.in.dto.CityResponseDto;
import com.helmes.cities.domain.CityAggregate;
import com.helmes.cities.domain.entities.City;
import com.helmes.cities.domain.exceptions.CityNotFoundException;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CityControllerTest {

  private CityController controller;
  @Mock
  CityAggregate cityAggregate;

  @BeforeEach
  void setUp() {
    controller = new CityRestService(cityAggregate);
  }

  @Test
  void getAllCities_thenReturnListOfCities() {
    final City city1 = City.builder().Id("123").name("name1").photoUrl("url1").build();
    final City city2 = City.builder().Id("456").name("name2").photoUrl("url2").build();
    final List<City> cities = Arrays.asList(city1, city2);
    when(cityAggregate.findAllCities()).thenReturn(cities);
    // When
    final List<CityResponseDto> result = controller.getAllCities();
    // Then
    assertNotNull(result);
    assertEquals(2, result.size());
    verify(cityAggregate, times(1)).findAllCities();
  }

  @Test
  void getCityByName_thenReturnCity() {
    final City city1 = City.builder().Id("123").name("name1").photoUrl("url1").build();
    when(cityAggregate.findCityByName(any())).thenReturn(city1);
    // When
    final CityResponseDto cityByName = controller.getCityByName("name");
    // Then
    assertNotNull(cityByName);
    verify(cityAggregate, times(1)).findCityByName("name");
  }

  @Test
  void editCity_thenReturnTrue() {
    final CityDto city1 = CityDto.builder().Id("123").name("name1").photoUrl("url1").build();
    final City city = City.builder().Id("123").name("name1").photoUrl("url1").build();
    when(cityAggregate.editCity(any())).thenReturn(true);
    // When
    final Boolean updated = controller.editCity(city1, "123");
    // Then
    assertTrue(updated);
    verify(cityAggregate, times(1)).editCity(city);
  }

  @Test
  void editCity_whenThrowsException_thenReturnFalse() {
    final CityDto city1 = CityDto.builder().Id("123").name("name1").photoUrl("url1").build();
    final City city = City.builder().Id("123").name("name1").photoUrl("url1").build();
    when(cityAggregate.editCity(any())).thenThrow(CityNotFoundException.class);
    // When
    final Boolean updated = controller.editCity(city1, "123");
    // Then
    assertFalse(updated);
    verify(cityAggregate, times(1)).editCity(city);
  }
}
