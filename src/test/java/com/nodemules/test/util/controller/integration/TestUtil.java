package com.nodemules.test.util.controller.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author brent
 * @since 10/25/17.
 * @version 0.1.0
 */
@Slf4j
public final class TestUtil {

  private static final ObjectMapper mapper = new ObjectMapper();

  private TestUtil() {
    /* empty private constructor */
  }

  public static <T> T parseJSON(String json, Class<T> clazz) throws IOException {
    return mapper.readValue(json, new TypeReference<T>() {
    });
  }

  public static void logResponse(MvcResult result) throws IOException {
    final int MAX_JSON_LENGTH = 1000;
    MockHttpServletRequest req = result.getRequest();
    String responseBody = result.getResponse()
        .getContentAsString();
    if (responseBody == null || responseBody.isEmpty()) {
      log.info("Result from test was null or empty: {}", responseBody);
      return;
    }
    Object json;
    try {
      json = mapper.readValue(responseBody, new TypeReference<Map<String, Object>>() {
      });
    } catch (JsonMappingException e) {
      json = mapper.readValue(responseBody, new TypeReference<List<Map<String, Object>>>() {
      });
    }
    String jsonString = mapper.writerWithDefaultPrettyPrinter()
        .writeValueAsString(json);
    boolean trimmed = responseBody.length() > MAX_JSON_LENGTH;
    if (trimmed) {
      jsonString = jsonString.substring(0, MAX_JSON_LENGTH);
      jsonString += "\n...";
    }
    log.info("Printing result for test for: {} {}\n{}", req.getMethod(), req.getPathInfo(), jsonString);
  }

}
