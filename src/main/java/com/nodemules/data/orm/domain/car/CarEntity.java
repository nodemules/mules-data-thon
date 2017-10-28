package com.nodemules.data.orm.domain.car;

import lombok.Data;

import javax.persistence.*;

/**
 * @author brent
 * @version 0.1.0
 * @since 10/26/17.
 */
@Data
@Entity
@Table(name = "car")
public class CarEntity {

  @Id
  @Column(name = "car_id")
  @GeneratedValue
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "model_id")
  private ModelEntity model;

  private int miles;
  private int year;

}
