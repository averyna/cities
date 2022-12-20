package com.helmes.cities.adapter.in;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helmes.cities.adapter.in.dto.CityDto;
import com.helmes.cities.adapter.in.dto.CityResponseDto;
import com.helmes.cities.adapter.out.helper.CityCSVLoader;
import com.helmes.cities.domain.CityAggregate;
import com.helmes.cities.domain.entities.City;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CityControllerIntegrationTest {
  @MockBean
  CityCSVLoader cityCSVLoader;

  TestRestTemplate restTemplate;
  URL base;
  @LocalServerPort
  int port;

  @MockBean
  CityAggregate cityAggregate;

  @Before
  public void setUp() throws MalformedURLException {
    restTemplate = new TestRestTemplate();
    base = new URL("http://localhost:" + port);
  }

  @Test
  public void givenCitiesURI_whenSendingReq_thenVerifyResponse() throws Exception {
    final City city1 = City.builder().Id("123").name("name1").photoUrl("url1").build();
    final City city2 = City.builder().Id("456").name("name2").photoUrl("url2").build();
    final List<City> cities = Arrays.asList(city1, city2);
    when(cityAggregate.findAllCities()).thenReturn(cities);

    ResponseEntity<String> response =
        restTemplate.getForEntity(base.toString() + "/cities", String.class);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(new ObjectMapper().writeValueAsString(cities), response.getBody());
  }

  @Test
  public void givenCitiesNameURI_whenSendingGetReq_thenVerifyResponse() {
    final City city1 = City.builder().Id("123").name("London").photoUrl("url").build();
    when(cityAggregate.findCityByName(any())).thenReturn(city1);
    CityResponseDto responseDto = CityResponseDto.builder().Id("123").name("London").photoUrl("url").build();

    ResponseEntity<CityResponseDto> response =
        restTemplate.getForEntity(base.toString() + "/cities/London", CityResponseDto.class);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertNotNull(response.getBody());
    assertEquals(responseDto, response.getBody());
  }

  @Test
  public void givenCitiesEditURI_whenSendingPutReq_thenVerifyResponse() {
    when(cityAggregate.editCity(any())).thenReturn(any());

    CityDto dto = CityDto.builder().Id("123").name("London").photoUrl("url").build();

    ResponseEntity<Boolean> response =
        restTemplate.exchange(base.toString() + "/cities/id", HttpMethod.PUT, new HttpEntity<>(dto), Boolean.class);

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertTrue(response.getBody());
  }
}
