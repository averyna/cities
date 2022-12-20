package com.helmes.cities.adapter.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CityResponseDto {
  private String Id;
  private String name;
  private String photoUrl;
}
