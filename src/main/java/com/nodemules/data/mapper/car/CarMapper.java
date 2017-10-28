package com.nodemules.data.mapper.car;

import com.nodemules.data.api.car.bean.Car;
import com.nodemules.data.api.car.bean.Make;
import com.nodemules.data.api.car.bean.Model;
import com.nodemules.data.core.car.model.CarModel;
import com.nodemules.data.orm.domain.car.CarEntity;
import com.nodemules.data.orm.domain.car.MakeEntity;
import com.nodemules.data.orm.domain.car.ModelEntity;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

import java.util.List;

/**
 * @author brent
 * @version 0.1.0
 * @since 10/26/17.
 */
@Mapper
public interface CarMapper {

  @Maps(withCustomFields = {
      @Field(value = { "Car.make", "CarEntity.model.make" }),
      @Field(value = { "Car.model", "CarEntity.model" })
  }, withIgnoreFields = { "Car.model", "Car.model.make" })
  Car toCar(CarEntity entity);

  List<Car> toCarList(List<CarEntity> entities);

  @Maps(withIgnoreFields = { "id" })
  CarEntity toCarEntity(CarModel model);

  @Maps(withIgnoreFields = { "ModelEntity.make", "Model.make" })
  Model toModel(ModelEntity modelEntity);

  @Maps(withIgnoreFields = { "ModelEntity.make", "Model.make" })
  List<Model> toModelList(List<ModelEntity> modelEntities);

  @Maps(withIgnoreFields = { "MakeEntity.models", "Make.models" })
  Make toMake(MakeEntity makeEntity);

  @Maps(withIgnoreFields = { "Make.models" })
  List<Make> toMakeList(List<MakeEntity> makeEntities);

}
