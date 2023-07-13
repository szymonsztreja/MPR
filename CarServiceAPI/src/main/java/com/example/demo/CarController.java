package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {
    CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("car/id/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
        Optional<Car> carOptional = carService.findCarById(id);
        return new ResponseEntity<>(carOptional.get(), HttpStatus.OK);
    }

    @GetMapping("cars/all")
    public List<Car> getAllCars(){
        List<Car> cars = carService.findAll();
        return  cars;
    }

    @GetMapping("car/make/{make}")
    public ResponseEntity<Car> getCarByMake(@PathVariable String make){
        Car car = carService.findCarByMake(make);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping("car/NP/{np}")
    public ResponseEntity<Car> getCarByNumberPlate(@PathVariable String np){
        Car car = carService.findCarByNumberPlate(np);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/add")
    public void saveCarToDataBase(@RequestBody Car car){
        carService.saveCarToRepository(car);
    }

    @PatchMapping("/patch/car/{id}")
    public void updateCarInRepository(@RequestBody Car car){
        carService.updateCarNumberPlateById(car);
    }
}
