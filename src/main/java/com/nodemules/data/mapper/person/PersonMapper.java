package com.nodemules.data.mapper.person;

import com.nodemules.data.api.person.bean.Person;
import com.nodemules.data.core.person.model.PersonModel;
import fr.xebia.extras.selma.Mapper;

/**
 * @author brent
 * @since 10/24/17.
 */
@Mapper(
    withIgnoreFields = {"Person.id"}
)
public interface PersonMapper {

  Person toPerson(PersonModel model);

  PersonModel toModel(Person person);
}
