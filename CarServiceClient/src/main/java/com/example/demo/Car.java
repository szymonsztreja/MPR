package com.example.demo;

public class Car {

    private Long id;
    private String make;
    private String numberPlate;

    public Car(){};

    public Car(String make, String numberPlate) {
        this.make = make;
        this.numberPlate = numberPlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }
}
