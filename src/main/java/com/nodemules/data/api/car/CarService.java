package com.nodemules.data.api.car;

import com.nodemules.data.api.car.bean.Car;
import com.nodemules.data.api.car.bean.Make;
import com.nodemules.data.api.car.bean.Model;
import com.nodemules.data.mapper.car.CarMapper;
import com.nodemules.data.orm.repository.CarMakeRepository;
import com.nodemules.data.orm.repository.CarModelRepository;
import com.nodemules.data.orm.repository.CarRepository;
import fr.xebia.extras.selma.Selma;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author brent
 * @since 10/24/17.
 * @version 0.1.0
 */
@Slf4j
@Service
public class CarService implements CarOperations {

  @Autowired
  private CarRepository carRepo;

  @Autowired
  private CarModelRepository carModelRepo;

  @Autowired
  private CarMakeRepository carMakeRepo;

  private static CarMapper carMapper = Selma.builder(CarMapper.class).build();

  @Override
  public Car getCar(Long id) {
    return carMapper.toCar(carRepo.findOne(id));
  }

  @Override
  public List<Car> getCars() {
    return carMapper.toCarList(carRepo.findAll());
  }

  @Override
  public List<Make> getCarMakes() {
    return carMapper.toMakeList(carMakeRepo.findAll());
  }

  @Override
  public List<Model> getCarModels(Make make) {
    return getCarModels(make.getId());
  }

  @Override
  public List<Model> getCarModels(long makeId) {
    return carMapper.toModelList(carModelRepo.findByMakeId(makeId));
  }

}
