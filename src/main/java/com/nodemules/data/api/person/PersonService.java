package com.nodemules.data.api.person;

import com.nodemules.data.api.person.bean.Person;
import com.nodemules.data.core.person.PersonTemplate;
import com.nodemules.data.mapper.person.PersonMapper;
import com.nodemules.data.util.math.MathUtil;
import fr.xebia.extras.selma.Selma;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author brent
 * @since 10/24/17.
 * @version 0.1.0
 */
@Slf4j
@Service
public class PersonService implements PersonOperations {

  @Autowired
  private PersonTemplate personEngine;

  private static PersonMapper personMapper = Selma.builder(PersonMapper.class).build();

  @Override
  public Person getPerson(Long id) {
    Person p = personMapper.toPerson(personEngine.generate());
    p.setId(id);
    return p;
  }

  @Override
  public List<Person> getPersons() {
    List<Person> persons = new ArrayList<>();
    int rand = MathUtil.getRandomInteger(1000);
    log.info("Generating {} new people", rand);
    for (int i = 0; i < rand; i++) {
      Person p = personMapper.toPerson(personEngine.generate());
      p.setId((long) i);
      persons.add(p);
    }
    return persons;
  }

}
