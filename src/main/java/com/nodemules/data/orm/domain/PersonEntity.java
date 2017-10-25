package com.nodemules.data.orm.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author brent
 * @since 10/25/17.
 * @version 0.1.0
 */
@Data
@Entity
@Table(name = "person")
public class PersonEntity implements Serializable {

  private static final long serialVersionUID = 3828598328261781831L;

  @Id
  @Column(name = "person_id")
  @GeneratedValue
  private Long id;

  private String firstName;
  private String lastName;
  private String middleName;

  private Date dateOfBirth;

}
