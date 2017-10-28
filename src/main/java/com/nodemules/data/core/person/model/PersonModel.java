package com.nodemules.data.core.person.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author brent
 * @since 10/24/17.
 * @version 0.1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonModel {

  private String firstName;
  private String lastName;
  private String middleName;

  private Date dateOfBirth;

}
