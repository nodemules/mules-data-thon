package com.nodemules.data.api.controller.test.integration;

import com.nodemules.data.DataApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author brent
 * @since 10/24/17.
 */
@Slf4j
@SpringBootTest
@ContextConfiguration(classes = {DataApplication.class})
public abstract class AbstractControllerIntegrationTest {

  @Autowired
  protected WebApplicationContext webApplicationContext;

  protected MockMvc mockMvc;

  @Before
  public void setup() {
    mockMvc = MockMvcBuilders
        .webAppContextSetup(webApplicationContext)
        .alwaysDo((result) -> {
          MockHttpServletRequest req = result.getRequest();
          log.info("Printing result for test for: {} {}", req.getMethod(), req.getPathInfo());
          log.info(result.getResponse().getContentAsString());
        })
        .build();
  }
}
