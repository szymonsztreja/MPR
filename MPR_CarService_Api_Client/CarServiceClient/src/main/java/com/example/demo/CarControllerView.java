package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CarControllerView {
    private CarService carService;

    public CarControllerView(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/show")
    public String showAllCars(Model model){
        List<Car> cars =  carService.findAll();
        model.addAttribute("samochody", cars);
        return "cars";
    }

    @GetMapping("/car/add")
    public String addCarForm(Model model){
        model.addAttribute("car", new Car());
        return "add-car-form";
    }

    @PostMapping("/add")
    public String addCarSubmit(@ModelAttribute Car car){
        carService.saveCar();
        return "redirect:/cars";
    }
}
