package com.nodemules.data.orm.domain.car;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * @author brent
 * @since 10/26/17.
 */
@Data
@Entity
@Table(name = "make")
@EqualsAndHashCode(exclude = "models")
public class MakeEntity {

  @Id
  @Column(name="make_id")
  @GeneratedValue
  private Long id;
  private String name;

  @OneToMany(mappedBy = "make")
  private Set<ModelEntity> models;

}
