package com.nodemules.data.api.controller.test.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.nodemules.data.api.generator.bean.GeneratorResponse;
import com.nodemules.data.api.person.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.json.JsonContentAssert;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author brent
 * @since 10/25/17.
 * @version 0.1.0
 */
@RunWith(SpringRunner.class)
@Slf4j
public class GeneratorControllerTest extends AbstractControllerIntegrationTest {
  //GeneratorResponse<Person>

  private static final String BASE_URL = "/api/generator";

  private static final Integer NUMBER_OF_PERSONS_TO_GENERAGE = 10;

  @Test
  public void generatePersons() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/person"))
        .andExpect(MockMvcResultMatchers.status()
            .isOk())
        .andExpect((result) -> {
          GeneratorResponse<Person> generatorResponse = mapper.readValue(result.getResponse()
              .getContentAsString(), new TypeReference<GeneratorResponse<Person>>() {
          });
          Assert.assertTrue(generatorResponse.getEntityIds()
              .size() == generatorResponse.getEntitiesGenerated());
          assertPerson(generatorResponse.getSampleEntity());
        })
        .andReturn();
  }

  @Test
  public void generateSomePersons() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/person")
        .param("number", NUMBER_OF_PERSONS_TO_GENERAGE.toString()))
        .andExpect(MockMvcResultMatchers.status()
            .isOk())
        .andExpect((result) -> {
          GeneratorResponse<Person> generatorResponse = mapper.readValue(result.getResponse()
              .getContentAsString(), new TypeReference<GeneratorResponse<Person>>() {
          });
          Assert.assertTrue(generatorResponse.getEntitiesGenerated() == NUMBER_OF_PERSONS_TO_GENERAGE);
          assertPerson(generatorResponse.getSampleEntity());
        })
        .andReturn();
  }

  private void assertPerson(Person p) throws JsonProcessingException {
    JsonContentAssert jsonAssert = new JsonContentAssert(Person.class, mapper.writeValueAsString(p));
    jsonAssert.doesNotHaveEmptyJsonPathValue("id", p);
    jsonAssert.doesNotHaveEmptyJsonPathValue("firstName", p);
    jsonAssert.doesNotHaveEmptyJsonPathValue("lastName", p);
  }

}
