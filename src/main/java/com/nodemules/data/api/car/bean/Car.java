package com.nodemules.data.api.car.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author brent
 * @since 10/24/17.
 * @version 0.1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Car {

  private long id;

  @JsonIgnoreProperties(value = { "models" })
  private Make make;

  @JsonIgnoreProperties(value = { "make" })
  private Model model;

  private int miles;
  private int year;

}
