package com.nodemules.data.orm.repository;

import com.nodemules.data.orm.domain.car.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author brent
 * @since 10/26/17.
 * @version 0.1.0
 */
@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

  List<CarEntity> findByModelMakeName(String name);

}
