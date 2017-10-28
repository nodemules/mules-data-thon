package com.nodemules.data.api.controller.test.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nodemules.data.api.car.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.json.JsonContentAssert;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author brent
 * @since 10/26/17.
 * @version 0.1.0
 */
@RunWith(SpringRunner.class)
@Slf4j
public class CarControllerTest extends AbstractControllerIntegrationTest {

  private static final Long TEST_CAR_ID = 1L;

  @Before
  public void generateCars() {
    generatorService.generateCars(10);
  }

  @Test
  public void getCar() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/car/{id}", TEST_CAR_ID))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect((result) -> {
          ObjectMapper mapper = new ObjectMapper();
          Car p = mapper.readValue(result.getResponse().getContentAsString(), Car.class);
          Assert.assertTrue(TEST_CAR_ID.equals(p.getId()));
        })
        .andExpect(MockMvcResultMatchers.jsonPath("miles").isNumber())
        .andExpect(MockMvcResultMatchers.jsonPath("year").isNumber())
        .andReturn();
  }

  @Test
  public void getCars() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/car/"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect((result) -> {
          List<Car> list = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Car>>() {});
          Car car = list.get(ThreadLocalRandom.current().nextInt(list.size()));

          JsonContentAssert jsonAssert = new JsonContentAssert(Car.class, mapper.writeValueAsString(car));
          jsonAssert.doesNotHaveEmptyJsonPathValue("id", car);
          jsonAssert.doesNotHaveEmptyJsonPathValue("miles", car);
          jsonAssert.doesNotHaveEmptyJsonPathValue("year", car);
        })
        .andReturn();
  }

}
