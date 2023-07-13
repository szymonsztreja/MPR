package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CarService {
    CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
        carRepository.save(new Car("bmw", "blabla"));
        carRepository.save(new Car("audi", "gda1232"));
    }


    public Optional<Car> findCarById(Long id){
        return carRepository.findById(id);
    }
    public Car findCarByMake(String make){
        return carRepository.findCarByMake(make);
    }

    public Car findCarByNumberPlate(String numberPlate){
        return carRepository.findCarByNumberPlate(numberPlate);
    }

    public void saveCarToRepository(Car car){
        carRepository.save(car);
    }

    public void updateCarById(Long id, Map<String, Object> fields) {
        Car myCar = carRepository.findById(id).orElseThrow(() -> new RuntimeException());

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Car.class, key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, myCar, value);
        });
        carRepository.save(myCar);
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }

    public List<Car> findAll() {
        return (List<Car>) carRepository.findAll();
    }
}
