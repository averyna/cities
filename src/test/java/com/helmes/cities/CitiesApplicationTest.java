package com.helmes.cities;

import com.helmes.cities.adapter.out.helper.CityCSVLoader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class CitiesApplicationTest {
	@MockBean
	CityCSVLoader cityCSVLoader;

	@Test
	void contextLoads() {
	}

}
