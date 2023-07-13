package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class CarControllerView {
    private CarService carService;

    public CarControllerView(CarService carService){
        this.carService = carService;
    }

    @GetMapping("/show")
    public String showAllCars(Model model){
        List<Car> cars = carService.findAll();
        model.addAttribute("samochody", cars);
        return "cars";
    }

    @GetMapping("/car/add")
    public String showAddForm(Model model){
        model.addAttribute("car", new Car());
        return "add-car-form";
    }

    @PostMapping("/car/add")
    public String submitAddForm(@ModelAttribute Car car){
        carService.saveCarToRepository(car);
        return "redirect:/car/add";
    }

    @PostMapping("updateCar/id/{id}")
    public String updateCarForm(@PathVariable Long id, @RequestBody Map<String, Object> fields){
        carService.updateCarById(id, fields);

    }
}
