package com.nodemules.data.mapper.person;

import com.nodemules.data.api.person.bean.Person;
import com.nodemules.data.core.person.model.PersonModel;
import com.nodemules.data.orm.domain.person.PersonEntity;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

import java.util.List;
import java.util.Set;

/**
 * @author brent
 * @since 10/24/17.
 * @version 0.1.0
 */
@Mapper
public interface PersonMapper {

  @Maps(withIgnoreFields = {"Person.id"})
  Person toPerson(PersonModel model);

  Person toPerson(PersonEntity entity);

  List<Person> toPersonList(List<PersonEntity> entities);

  List<Person> toPersonList(Set<PersonEntity> entities);

  @Maps(withIgnoreFields = {"PersonEntity.id"})
  PersonEntity toPersonEntity(PersonModel model);

  PersonEntity toPersonEntity(Person person);

}
