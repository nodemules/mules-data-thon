package com.nodemules.data.orm.domain.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author brent
 * @since 10/26/17.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "model")
@EqualsAndHashCode(exclude = "make")
public class ModelEntity {

  @Id
  @Column(name="model_id")
  @GeneratedValue
  private Long id;
  private String name;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "make_id")
  private MakeEntity make;

}
