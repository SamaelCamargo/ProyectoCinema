package com.cinema.usaCiclo3.repository.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cinema.usaCiclo3.model.Cinema;

public interface CinemaCRUD extends CrudRepository<Cinema,Integer>{

    List<Cinema> findAll();

    Optional<Cinema> findById(int id);

    Cinema save(Cinema c);
}
