package com.nodemules.data.api.generator;

import com.nodemules.data.api.generator.bean.GeneratorResponse;
import com.nodemules.data.api.person.bean.Person;
import com.nodemules.data.core.person.PersonTemplate;
import com.nodemules.data.mapper.person.PersonMapper;
import com.nodemules.data.orm.domain.PersonEntity;
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
 * @since 10/25/17.
 */
@Slf4j
@Service
public class GeneratorService implements GeneratorOperations {

  private static PersonMapper personMapper = Selma.builder(PersonMapper.class)
      .build();

  @Autowired
  private PersonTemplate personEngine;

  @Autowired
  private PersonRepository personRepo;

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

}
