package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    Car findCarByMake(String make);
    Car findCarByNumberPlate(String numberPlate);

}
