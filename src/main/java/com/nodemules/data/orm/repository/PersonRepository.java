package com.nodemules.data.orm.repository;

import com.nodemules.data.orm.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * @author brent
 * @since 10/25/17.
 * @version 0.1.0
 */
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {

  List<PersonEntity> findByIdIn(Set<Long> ids);
}
