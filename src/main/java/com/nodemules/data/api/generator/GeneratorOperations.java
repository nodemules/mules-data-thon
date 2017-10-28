package com.nodemules.data.api.generator;

import com.nodemules.data.api.car.bean.Car;
import com.nodemules.data.api.generator.bean.GeneratorResponse;
import com.nodemules.data.api.person.bean.Person;

/**
 * @author brent
 * @since 10/25/17.
 * @version 0.1.0
 */
public interface GeneratorOperations {

  /**
   * Generates a random number of Persons
   *
   * @return
   */
  GeneratorResponse generatePersons();

  /**
   * Generates the given number of Persons
   *
   * @param bound
   * @return
   */
  GeneratorResponse<Person> generatePersons(int bound);

  /**
   * Generates a random number of Cars
   *
   * @return
   */
  GeneratorResponse<Car> generateCars();

  /**
   * Generates the given number of Cars
   *
   * @param bound
   * @return
   */
  GeneratorResponse<Car> generateCars(int bound);
}
