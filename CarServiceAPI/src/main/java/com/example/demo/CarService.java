package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
        carRepository.save(new Car("bmw", "blabla"));
        carRepository.save(new Car("audi", "gda1232"));
    }

    public List<Car> findAll(){
        return (List<Car>) carRepository.findAll();
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

    public void updateCarNumberPlateById(Car car) {

        //wyciagam z bazy i sprawdzam czy jest
        Car myCar = carRepository.findById(car.getId()).orElseThrow(() -> new RuntimeException());
        myCar.setMake(car.getMake());


        //jesli jest, aktualizuje
        carRepository.save(car);
    }
}
