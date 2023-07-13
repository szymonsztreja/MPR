package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("my-rest")
public class MyRestController {
    private MyRestService myRestService;

    @GetMapping("/{id}")
    public List<Belmondo> getBelmondo(@PathVariable int id) {
        return findById(id);
    }

    private List<Belmondo> findById(int id) {
        if (myRestService.getBelmondziaki().stream()
                .anyMatch(belmondo -> belmondo.getId() == id))
            return myRestService.getBelmondziaki();
        else return new ArrayList<>();
    }

    @DeleteMapping(path = "/{name}")
    public void delete(@PathVariable("name") String name){
        System.out.println(myRestService.getBelmondziaki().stream()
                .filter(belmondo -> belmondo.getName().equals(name)));

    }

}