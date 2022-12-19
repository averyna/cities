package com.helmes.cities.adapter.in.exceptions;

import org.springframework.http.HttpStatus;

public class RestCityNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -6884493330486261077L;
  private final int httpCode;

  public RestCityNotFoundException(String message, HttpStatus status) {
    super(message);
    this.httpCode = status.value();
  }
}
