package com.helmes.cities.adapter.out.repository;

import com.helmes.cities.adapter.out.model.CityEntity;
import com.helmes.cities.adapter.out.model.CityEntityMapper;
import com.helmes.cities.domain.entities.City;
import com.helmes.cities.domain.repository.CityRepository;
import java.util.List;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class PostgresCityRepository implements CityRepository {

  @Override
  public Boolean update(City city) {
    final CityEntity cityEntity = CityEntityMapper.toCityEntity(city);
//  save(cityEntity); here we save in db
    return true;
  }

  @Override
  public List<City> findAllCities() {
    return  null;
  }

  @Override
  public City searchByName(String name) {
    return null;
  }
}
