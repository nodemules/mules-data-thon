package com.nodemules.data.core.car.model;

import lombok.Data;

import java.util.List;

/**
 * @author brent
 * @since 10/26/17.
 * @version 0.1.0
 */
@Data
public class Make {

  private String name;
  private List<Model> models;

}
