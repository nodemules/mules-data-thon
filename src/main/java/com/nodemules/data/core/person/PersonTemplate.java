package com.nodemules.data.core.person;

import com.nodemules.data.core.person.model.PersonModel;

/**
 * @author brent
 * @since 10/24/17.
 * @version 0.1.0
 */
public interface PersonTemplate {

  /**
   * Generates a model of a person
   *
   * @return
   */
  PersonModel generate();

}
