package com.nodemules.data.orm.domain.person;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author brent
 * @since 10/25/17.
 * @version 0.1.0
 */
@Data
@Entity
@Table(name = "person")
public class PersonEntity {

  @Id
  @Column(name = "person_id")
  @GeneratedValue
  private Long id;

  private String firstName;
  private String lastName;
  private String middleName;

  private Date dateOfBirth;

}
