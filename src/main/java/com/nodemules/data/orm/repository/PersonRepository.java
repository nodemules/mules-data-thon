package com.nodemules.data.orm.repository;

import com.nodemules.data.orm.domain.person.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author brent
 * @version 0.1.0
 * @since 10/25/17.
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

  List<PersonEntity> findByIdIn(Set<Long> ids);

}
