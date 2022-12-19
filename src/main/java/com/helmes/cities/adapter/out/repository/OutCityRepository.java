package com.helmes.cities.adapter.out.repository;

import com.helmes.cities.adapter.out.model.CityEntity;
import com.helmes.cities.adapter.out.model.CityEntityMapper;
import com.helmes.cities.adapter.out.persistance.MongoCityRepository;
import com.helmes.cities.domain.entities.City;
import com.helmes.cities.domain.repository.CityRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
public class OutCityRepository implements CityRepository {

  private final MongoCityRepository repository;

  @Override
  public Boolean update(City city) {
    final CityEntity cityEntity = CityEntityMapper.toCityEntity(city);
    final CityEntity savedEntity = repository.save(cityEntity);
    return true;
  }

  @Override
  public List<City> findAllCities() {
    return StreamSupport.stream(repository.findAll().spliterator(), false)
        .map(CityEntityMapper::toCity)
        .collect(Collectors.toList());
  }

  @Override
  public City searchByName(String name) {
    final List<CityEntity> byName = repository.findByName(name);
    return CityEntityMapper.toCity(byName.get(0));
  }

  @Override
  public City searchById(String id) {
    final Optional<CityEntity> byId = repository.findById(id);
    return byId.map(CityEntityMapper::toCity).orElse(null);
  }
}
