package com.nodemules.data.api.generator;

import com.nodemules.data.api.car.bean.Car;
import com.nodemules.data.api.generator.bean.GeneratorResponse;
import com.nodemules.data.api.person.bean.Person;
import com.nodemules.data.core.car.CarTemplate;
import com.nodemules.data.core.person.PersonTemplate;
import com.nodemules.data.mapper.car.CarMapper;
import com.nodemules.data.mapper.person.PersonMapper;
import com.nodemules.data.orm.domain.car.CarEntity;
import com.nodemules.data.orm.domain.person.PersonEntity;
import com.nodemules.data.orm.repository.CarRepository;
import com.nodemules.data.orm.repository.PersonRepository;
import fr.xebia.extras.selma.Selma;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author brent
 * @version 0.1.0
 * @since 10/25/17.
 */
@Slf4j
@Service
public class GeneratorService implements GeneratorOperations {

  private static PersonMapper personMapper = Selma.builder(PersonMapper.class)
      .build();

  private static CarMapper carMapper = Selma.builder(CarMapper.class)
      .build();

  @Autowired
  private PersonTemplate personEngine;

  @Autowired
  private CarTemplate carEngine;

  @Autowired
  private PersonRepository personRepo;

  @Autowired
  private CarRepository carRepo;

  @Override
  public GeneratorResponse<Person> generatePersons() {
    return generatePersons(ThreadLocalRandom.current()
        .nextInt(1000));
  }

  @Override
  public GeneratorResponse<Person> generatePersons(int number) {

    log.info("Generating {} new Persons", number);

    List<PersonEntity> persons = new ArrayList<>();

    for (int i = 0; i < number; i++) {
      persons.add(personMapper.toPersonEntity(personEngine.generate()));
    }

    List<PersonEntity> entities = personRepo.save(persons);

    GeneratorResponse<Person> response = new GeneratorResponse();

    response.setEntitiesGenerated(entities.size());

    response.setSampleEntity(personMapper.toPerson(entities.get(ThreadLocalRandom.current()
        .nextInt(entities.size()))));

    response.setEntityIds(entities.stream()
        .map(PersonEntity::getId)
        .collect(Collectors.toSet()));

    return response;
  }


  @Override
  public GeneratorResponse<Car> generateCars() {
    return generateCars(ThreadLocalRandom.current()
        .nextInt(1000));
  }

  @Override
  public GeneratorResponse<Car> generateCars(int bound) {

    log.info("Generating {} new Cars", bound);

    List<CarEntity> cars = new ArrayList<>();

    for (int i = 0; i < bound; i++) {
      cars.add(carMapper.toCarEntity(carEngine.generate()));
    }

    List<CarEntity> entities = carRepo.save(cars);

    GeneratorResponse<Car> response = new GeneratorResponse();

    response.setEntitiesGenerated(entities.size());

    response.setSampleEntity(carMapper.toCar(entities.get(ThreadLocalRandom.current()
        .nextInt(entities.size()))));

    response.setEntityIds(entities.stream()
        .map(CarEntity::getId)
        .collect(Collectors.toSet()));

    return response;
  }

}
