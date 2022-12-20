package com.helmes.cities.adapter.in.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CityResponseDtoList {
  private List<CityResponseDto> list;
}
