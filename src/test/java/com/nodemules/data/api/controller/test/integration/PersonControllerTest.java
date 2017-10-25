package com.nodemules.data.api.controller.test.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nodemules.data.api.person.bean.Person;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author brent
 * @since 10/24/17.
 */
@RunWith(SpringRunner.class)
public class PersonControllerTest extends AbstractControllerIntegrationTest {

  private static final Long TEST_PERSON_ID = 1L;

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

}
