package com.helmes.cities.adapter.in;


import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.helmes.cities.adapter.in.dto.CityDto;
import com.helmes.cities.adapter.in.dto.CityResponseDto;
import com.helmes.cities.adapter.in.dto.CityResponseDtoList;
import com.helmes.cities.adapter.in.exceptions.RestCityNotFoundException;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
    final ResponseEntity<CityResponseDtoList> result = controller.getAllCities();
    // Then
    assertNotNull(result.getBody());
    assertEquals(2, result.getBody().getList().size());
    verify(cityAggregate, times(1)).findAllCities();
  }

  @Test
  void getCityByName_thenReturnCity() {
    final City city1 = City.builder().Id("123").name("name1").photoUrl("url1").build();
    when(cityAggregate.findCityByName(any())).thenReturn(city1);
    // When
    final ResponseEntity<CityResponseDto> cityByName = controller.getCityByName("name");
    // Then
    assertNotNull(cityByName.getBody());
    verify(cityAggregate, times(1)).findCityByName("name");
  }

  @Test
  void editCity_thenReturnTrue() {
    final CityDto city1 = CityDto.builder().Id("123").name("name1").photoUrl("url1").build();
    final City cityForAggregate = City.builder().Id("123").name("name1").photoUrl("url1").build();
    final City cityForResponse = City.builder().Id("123").name("London").photoUrl("url1").build();
    when(cityAggregate.editCity(any())).thenReturn(cityForResponse);
    // When
    final ResponseEntity<CityResponseDto> responseEntity = controller.editCity(city1, "123");
    // Then
    assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    assertEquals("London", responseEntity.getBody().getName());
    verify(cityAggregate, times(1)).editCity(cityForAggregate);
  }

  @Test
  void editCity_whenCityNotFound_throwsException() {
    final CityDto city1 = CityDto.builder().Id("123").name("name1").photoUrl("url1").build();
    final City city = City.builder().Id("123").name("name1").photoUrl("url1").build();
    when(cityAggregate.editCity(any())).thenThrow(CityNotFoundException.class);
    // When
    final RestCityNotFoundException result =
            assertThrows(
                RestCityNotFoundException.class,
                () ->
                    controller.editCity(city1, "123"));
    // Then
    verify(cityAggregate, times(1)).editCity(city);
    assertEquals(HttpStatus.NOT_FOUND.value(), result.getHttpCode());
  }
}
