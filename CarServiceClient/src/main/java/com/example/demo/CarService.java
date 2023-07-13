package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final String API_URL = "http://localhost:8081/";

    RestTemplate restTemplate;

    public CarService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<Car> findAll(){
        ResponseEntity<Car[]> response = restTemplate.getForEntity(API_URL
                + "cars/all" , Car[].class);
        if( response.getBody() != null){
            return Arrays.asList(response.getBody());
        } else {
            throw new CarsNotFoundException();
        }
    }

    public Car saveCar(){
        ResponseEntity<Car> response = restTemplate.postForObject(API_URL
                + "add", Car.class );
        if( response.getBody() != null){
            return response.getBody();
        } else {
            throw new CarNotFoundExecption();
        }
    }
//
//    public Car findCarByNumberPlate(String numberPlate){
//        return carRepository.findCarByNumberPlate(numberPlate);
//    }
//
//    public void saveCarToRepository(Car car){
//        carRepository.save(car);
//    }
//
//    public void updateCarNumberPlateById(Car car) {
//
//        //wyciagam z bazy i sprawdzam czy jest
//        Car myCar = carRepository.findById(car.getId()).orElseThrow(() -> new RuntimeException());
//        myCar.setMake(car.getMake());
//
//
//        //jesli jest, aktualizuje
//        carRepository.save(car);
//    }
}
