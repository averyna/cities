package com.helmes.cities.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CityResponseDto {
  private Long Id;
  private String name;
  private String photoUrl;
}
