package com.helmes.cities.adapter.out.persistance;

import com.helmes.cities.adapter.out.model.CityEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoCityRepository extends CrudRepository<CityEntity, Long> {
  List<CityEntity> findByName(String name);
}
