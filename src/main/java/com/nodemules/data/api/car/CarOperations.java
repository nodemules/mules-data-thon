package com.nodemules.data.api.car;

import com.nodemules.data.api.car.bean.Car;
import com.nodemules.data.api.car.bean.Make;
import com.nodemules.data.api.car.bean.Model;

import java.util.List;

/**
 * @author brent
 * @since 10/24/17.
 * @version 0.1.0
 */
public interface CarOperations {

  /**
   * Gets a car by id
   *
   * @param id
   * @return
   */
  Car getCar(Long id);

  /**
   * Gets a list of all the cars
   *
   * @return
   */
  List<Car> getCars();

  List<Make> getCarMakes();

  List<Model> getCarModels(Make make);

  List<Model> getCarModels(long makeId);
}
