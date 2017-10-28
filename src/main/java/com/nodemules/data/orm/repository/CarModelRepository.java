package com.nodemules.data.orm.repository;

import com.nodemules.data.orm.domain.car.ModelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author brent
 * @since 10/27/17.
 */
@Repository
public interface CarModelRepository extends JpaRepository<ModelEntity, Long> {

  List<ModelEntity> findByMakeId(Long id);
}
