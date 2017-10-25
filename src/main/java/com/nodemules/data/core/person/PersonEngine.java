package com.nodemules.data.core.person;

import com.github.javafaker.Faker;
import com.nodemules.data.core.person.model.PersonModel;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author brent
 * @since 10/24/17.
 */
@Service
public class PersonEngine implements PersonTemplate {

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
    p.setDateOfBirth(faker.date().past(8000, TimeUnit.DAYS));
    return p;
  }

}
