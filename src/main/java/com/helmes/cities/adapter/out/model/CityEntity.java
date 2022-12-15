package com.helmes.cities.adapter.out.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
//@Entity
//@Table(name = "cities")
public class CityEntity {
  private Long Id;

  private String name;

  private String photo;
}
