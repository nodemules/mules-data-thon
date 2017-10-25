package com.nodemules.data.api.person;

import com.nodemules.data.api.person.bean.Person;
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
@RequestMapping("/api/person")
public class PersonController {

  @Autowired
  private PersonOperations personService;

  @RequestMapping
  public List<Person> getPersons() {
    return personService.getPersons();
  }

  @RequestMapping(value = "/{id}")
  public Person getPerson(@PathVariable Long id) {
    return personService.getPerson(id);
  }
}
