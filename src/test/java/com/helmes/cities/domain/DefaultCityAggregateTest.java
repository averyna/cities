package com.helmes.cities.domain;

import static org.mockito.Mockito.when;

import com.helmes.cities.domain.entities.City;
import com.helmes.cities.domain.repository.CityRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DefaultCityAggregateTest {

  CityAggregate aggregate;
  @Mock
  CityRepository repository;

  private void setUp() {
    aggregate = new DefaultCityAggregate(repository);
  }
  @Test
  void findAllCities() {
    final City city1 = City.builder().Id("123").name("name1").photoUrl("url1").build();
    final City city2 = City.builder().Id("456").name("name2").photoUrl("url2").build();
    final List<City> cities = Arrays.asList(city1, city2);
    when(repository.findAllCities()).thenReturn(cities);
  }

  @Test
  void findCityByName() {
    //Todo:
  }

  @Test
  void findCityById() {
    //Todo:
  }

  @Test
  void editCity() {
    //Todo:
  }
}
