package com.cinema.usaCiclo3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cinema.usaCiclo3.model.Cinema;
import com.cinema.usaCiclo3.service.CinemaService;

@RestController
@RequestMapping("api/Cinema")
@CrossOrigin(origins = "*", methods = {
    RequestMethod.GET,
    RequestMethod.POST,
    RequestMethod.PUT,
    RequestMethod.DELETE,
})

public class CinemaController {
    
    @Autowired
    private CinemaService cinemaService;
    
    @GetMapping("/all")
    public List<Cinema> getCinema() {return cinemaService.getAll();  }

    @GetMapping("/{id}")
    public Optional<Cinema> getCinema(@PathVariable("id")int id){
        return cinemaService.getCinema(id);
    }
    
    @PostMapping("/save")
    public Cinema save(@RequestBody Cinema c){
        return cinemaService.save(c);
    }
}
