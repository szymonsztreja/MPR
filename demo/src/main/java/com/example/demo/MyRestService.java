package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyRestService {
    private List<Belmondo> belmondziaki;

    public MyRestService() {
        belmondziaki = List.of(
                new Belmondo(1, "Tytus", "Szyluk"),
                new Belmondo(2, "Tyfus", "Szyszuk"),
                new Belmondo(3, "Syfus", "Tyszuk"));
    }

    public void addBelmondziak(Belmondo belmondo){
        this.belmondziaki.add(belmondo);
    }

    public List<Belmondo> getBelmondziaki() {
        return belmondziaki;
    }
}
