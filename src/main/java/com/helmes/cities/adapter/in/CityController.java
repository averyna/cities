package com.helmes.cities.adapter.in;

import com.helmes.cities.adapter.in.dto.CityDto;
import com.helmes.cities.adapter.in.dto.CityResponseDto;
import com.helmes.cities.adapter.in.dto.CityResponseDtoList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/cities")
public interface CityController {

  @GetMapping
  ResponseEntity<CityResponseDtoList> getAllCities();

  @GetMapping(path = "/{name}")
  ResponseEntity<CityResponseDto> getCityByName(@PathVariable String name);

  @PutMapping("/{id}")
  ResponseEntity<CityResponseDto> editCity(@RequestBody CityDto cityDto, @PathVariable String id);

}
