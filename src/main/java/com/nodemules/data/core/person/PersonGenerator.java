package com.nodemules.data.core.person;

import com.github.javafaker.Faker;
import com.nodemules.data.core.person.model.PersonModel;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author brent
 * @since 10/24/17.
 * @version 0.1.0
 */
@Service
public class PersonGenerator implements PersonTemplate {

  private static Faker faker;

  @PostConstruct
  public void setFaker() {
    faker = new Faker();
  }

  @Override
  public PersonModel generate() {
    PersonModel p = new PersonModel();
    p.setFirstName(faker.name().firstName());
    p.setLastName(faker.name().lastName());
    p.setDateOfBirth(faker.date().past(110 * 365, TimeUnit.DAYS));
    return p;
  }

}
