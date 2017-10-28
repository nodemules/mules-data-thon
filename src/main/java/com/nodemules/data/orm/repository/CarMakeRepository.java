package com.nodemules.data.orm.repository;

import com.nodemules.data.orm.domain.car.MakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author brent
 * @since 10/27/17.
 */
@Repository
public interface CarMakeRepository extends JpaRepository<MakeEntity, Long> {

}
