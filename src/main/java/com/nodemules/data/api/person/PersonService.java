package com.nodemules.data.api.person;

import com.nodemules.data.api.person.bean.Person;
import com.nodemules.data.mapper.person.PersonMapper;
import com.nodemules.data.orm.repository.PersonRepository;
import fr.xebia.extras.selma.Selma;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
  private PersonRepository personRepo;

  private static PersonMapper personMapper = Selma.builder(PersonMapper.class).build();

  @Override
  public Person getPerson(Long id) {
    return personMapper.toPerson(personRepo.findOne(id));
  }

  @Override
  public List<Person> getPersons() {
    return personMapper.toPersonList(personRepo.findAll());
  }

}
