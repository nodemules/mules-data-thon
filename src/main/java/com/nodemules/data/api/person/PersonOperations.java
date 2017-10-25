package com.nodemules.data.api.person;

import com.nodemules.data.api.person.bean.Person;

import java.util.List;

/**
 * @author brent
 * @since 10/24/17.
 * @version 0.1.0
 */
public interface PersonOperations {

  /**
   * Gets a person by id
   *
   * @param id
   * @return
   */
  Person getPerson(Long id);

  List<Person> getPersons();
}
