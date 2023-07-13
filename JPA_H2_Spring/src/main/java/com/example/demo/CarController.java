//package com.example.demo;
//
//import com.example.demo.exceptions.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@RestController
//public class CarController {
//    CarService carService;
//
//    @Autowired
//    public CarController(CarService carService) {
//        this.carService = carService;
//    }
//
//    @GetMapping("car/id/{id}")
//    public ResponseEntity<Car> getCarById(@PathVariable Long id){
//        Optional<Car> carOptional = carService.findCarById(id);
//        if(carOptional.isPresent()){
//            return new ResponseEntity<>(carOptional.get(), HttpStatus.OK);
//        } else {
//            throw new CustomerNotFoundException();
//        }
//    }
//
//    @GetMapping("car/make/{make}")
//    public ResponseEntity<Car> getCarByMake(@PathVariable String make){
//        Optional<Car> carOptional = Optional.ofNullable(carService.findCarByMake(make));
//        if(carOptional.isPresent()){
//            return new ResponseEntity<>(carOptional.get(), HttpStatus.OK);
//        } else {
//            throw new CustomerNotFoundException();
//        }
//    }
//
//    @GetMapping("car/NP/{np}")
//    public ResponseEntity<Car> getCarByNumberPlate(@PathVariable String np){
//        Optional<Car> carOptional = Optional.ofNullable(carService.findCarByMake(np));
//        Car car = carService.findCarByNumberPlate(np);
//        if(carOptional.isPresent()){
//            return new ResponseEntity<>(carOptional.get(), HttpStatus.OK);
//        } else {
//            throw new CustomerNotFoundException();
//        }
//    }
//
//    @GetMapping("/show")
//    public String showAllCars(Model model){
//        List<Car> cars = carService.findAll();
//        model.addAttribute("samochody", cars);
//        return "cars";
//    }
//
//    @PostMapping("/post")
//    public ResponseEntity<Car> saveCarToRepository(@RequestBody Car car){
//        if (car.getNumberPlate().length() < 5){
//            throw new WrongRegistrationFormatException();
//        }
//        if ( car.getMake() == null ) {
//            throw new EmptyMakeException();
//        }
//        carService.saveCarToRepository(car);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PatchMapping("/{id}")
//    public ResponseEntity<Car> updateCarInRepository(@PathVariable Long id, @RequestBody Map<String, Object> fields){
//        if( !carService.findCarById(id).isPresent() ){
//            throw new CarDoesNotExistException();
//        }
//        carService.updateCarNumberPlateById(id, fields);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Car> deleteCarInRepository(@PathVariable Long id){
//        if ( !carService.findCarById(id).isPresent()){
//            throw new CarNotFoundException("Car id does not exist");
//        }
//        Optional<Car> car = carService.findCarById(id);
//        carService.deleteCarById(id);
//        return new ResponseEntity<>(car.get(), HttpStatus.OK);
//    }
//
//}
