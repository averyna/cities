package com.helmes.cities.domain.exceptions;

public class CityNotFoundException extends RuntimeException {

  public CityNotFoundException(String message) {
    super(message);
  }
}
