package com.nodemules.data.api.generator;

import com.nodemules.data.api.car.bean.Car;
import com.nodemules.data.api.generator.bean.GeneratorResponse;
import com.nodemules.data.api.person.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brent
 * @since 10/25/17.
 * @version 0.1.0
 */
@RestController
@RequestMapping("/api/generator")
public class GeneratorController {

  private GeneratorOperations generatorService;

  public GeneratorController(GeneratorService generatorService) {
    this.generatorService = generatorService;
  }

  @RequestMapping("/person")
  public GeneratorResponse<Person> generatePersons(@RequestParam(required = false) Integer number) {
    if (number == null) {
      return generatorService.generatePersons();
    }
    return generatorService.generatePersons(number);
  }

  @RequestMapping("/car")
  public GeneratorResponse<Car> generateCars(@RequestParam(required = false) Integer number) {
    if (number == null) {
      return generatorService.generateCars();
    }
    return generatorService.generateCars(number);
  }

}
