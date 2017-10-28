package com.nodemules.data.api.controller.test.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nodemules.data.api.person.bean.Person;
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
 * @since 10/24/17.
 * @version 0.1.0
 */
@RunWith(SpringRunner.class)
@Slf4j
public class PersonControllerTest extends AbstractControllerIntegrationTest {

  private static final Long TEST_PERSON_ID = 1L;

  @Before
  public void generatePersons() {
    generatorService.generatePersons(10);
  }

  @Test
  public void getPerson() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/person/{id}", TEST_PERSON_ID))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect((result) -> {
          ObjectMapper mapper = new ObjectMapper();
          Person p = mapper.readValue(result.getResponse().getContentAsString(), Person.class);
          Assert.assertTrue(TEST_PERSON_ID.equals(p.getId()));
        })
        .andExpect(MockMvcResultMatchers.jsonPath("firstName").isString())
        .andExpect(MockMvcResultMatchers.jsonPath("lastName").isString())
        .andReturn();
  }

  @Test
  public void getPersons() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/person/", TEST_PERSON_ID))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect((result) -> {
          List<Person> list = mapper.readValue(result.getResponse().getContentAsString(), new TypeReference<List<Person>>() {});
          Person p = list.get(ThreadLocalRandom.current().nextInt(list.size()));

          JsonContentAssert jsonAssert = new JsonContentAssert(Person.class, mapper.writeValueAsString(p));
          jsonAssert.doesNotHaveEmptyJsonPathValue("id", p);
          jsonAssert.doesNotHaveEmptyJsonPathValue("firstName", p);
          jsonAssert.doesNotHaveEmptyJsonPathValue("lastName", p);
        })
        .andReturn();
  }

}
