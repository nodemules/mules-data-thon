package com.nodemules.data.core.car;

import com.github.javafaker.Faker;
import com.nodemules.data.core.car.model.CarModel;
import com.nodemules.data.core.car.model.Make;
import com.nodemules.data.core.car.model.Model;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author brent
 * @since 10/26/17.
 * @version 0.1.0
 */
@Service
public class CarGenerator implements CarTemplate {

  private static Faker faker;

  @PostConstruct
  public void setFaker() {
    faker = new Faker();
  }

  @Override
  public CarModel generate() {
    CarModel car = new CarModel();

    Make make = new Make();
    make.setName(faker.commerce().productName());
    Model model = new Model();
    model.setName(faker.commerce().productName());
    model.setMake(make);
    car.setYear(new DateTime(faker.date().past(110 * 365, TimeUnit.DAYS)).getYear());
    car.setMiles(faker.random().nextInt(300_000));
    car.setModel(model);

    return car;
  }

}
