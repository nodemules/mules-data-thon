package com.nodemules.data.api.generator;

import com.nodemules.data.api.generator.bean.GeneratorResponse;
import com.nodemules.data.api.person.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author brent
 * @since 10/25/17.
 * @version 0.1.0
 */
@RestController
@RequestMapping("/api/generator")
public class GeneratorController {

  @Autowired
  private GeneratorOperations generatorService;

  @RequestMapping("/person")
  public GeneratorResponse<Person> generatePersons(@RequestParam Integer number) {
    if (number == null) {
      return generatorService.generatePersons();
    }
    return generatorService.generatePersons(number);
  }

}
