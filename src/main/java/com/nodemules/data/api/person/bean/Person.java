package com.nodemules.data.api.person.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.Date;

/**
 * @author brent
 * @since 10/24/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person implements Serializable {

  private static final long serialVersionUID = -1354480329353494933L;

  private Long id;

  @NonNull
  private String firstName;

  @NonNull
  private String lastName;

  private String middleName;

  private Date dateOfBirth;

  public Person(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

}
