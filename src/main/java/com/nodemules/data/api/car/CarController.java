package com.nodemules.data.api.car;

import com.nodemules.data.api.car.bean.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author brent
 * @since 10/24/17.
 * @version 0.1.0
 */
@RestController
@RequestMapping("/api/car")
public class CarController {

  @Autowired
  private CarOperations carService;

  @RequestMapping
  public List<Car> getCars() {
    return carService.getCars();
  }

  @RequestMapping(value = "/{id}")
  public Car getCar(@PathVariable Long id) {
    return carService.getCar(id);
  }
}
