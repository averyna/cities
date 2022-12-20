package com.helmes.cities.adapter.in.exceptions;

import org.springframework.http.HttpStatus;

public class RestCityNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -6884493330486261077L;
  private final int httpCode;

  private final Throwable ex;

  public RestCityNotFoundException(String message, HttpStatus status, Throwable ex) {
    super(message);
    this.httpCode = status.value();
    this.ex = ex;
  }

  public int getHttpCode() {
    return httpCode;
  }

  public Throwable getEx() {
    return ex;
  }
}
