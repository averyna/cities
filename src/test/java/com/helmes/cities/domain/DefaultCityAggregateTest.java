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
    //Todo:
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
