package com.cinema.usaCiclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.usaCiclo3.model.Cinema;
import com.cinema.usaCiclo3.repository.CinemaRepository;

@Service
public class CinemaService {
    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAll() {return cinemaRepository.getAll();}

    public Optional<Cinema> getCinema(int id){
        return cinemaRepository.getCinema(id);
    }
    
    public Cinema save(Cinema c){
        if (c.getId() ==null){
            return cinemaRepository.save(c);
        }else{
            Optional<Cinema> caux=cinemaRepository.getCinema(c.getId());
            if(caux.isEmpty()){
                return cinemaRepository.save(c);
            }else{
                return c;
            }
        }
    }
}
