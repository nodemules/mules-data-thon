package com.nodemules.data.api.controller.test.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nodemules.data.DataApplication;
import com.nodemules.data.api.generator.GeneratorOperations;
import com.nodemules.test.util.controller.integration.TestUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @author brent
 * @since 10/24/17.
 * @version 0.1.0
 */
@Slf4j
@SpringBootTest
@ContextConfiguration(classes = {DataApplication.class})
@ActiveProfiles("test")
public abstract class AbstractControllerIntegrationTest {

  @Autowired
  protected WebApplicationContext webApplicationContext;

  @Autowired
  protected GeneratorOperations generatorService;

  protected MockMvc mockMvc;

  protected ObjectMapper mapper;

  @PostConstruct
  public void postConstruct() {
    mapper = new ObjectMapper();
  }

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders
        .webAppContextSetup(webApplicationContext)
        .alwaysDo(TestUtil::logResponse)
        .build();
  }

}
