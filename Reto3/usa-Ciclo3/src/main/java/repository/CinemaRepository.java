package repository;

import model.Cinema;
import repository.crud.CinemaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CinemaRepository {
@Autowired
private CinemaCrudRepository cinemaCrudRepository;


public List<Cinema> getAll(){
    return (List<Cinema>) cinemaCrudRepository.findAll();
}

public Optional<Cinema> getCinema(int id){
    return cinemaCrudRepository.findById(id);
}

 public Cinema save (Cinema cinema){
    return cinemaCrudRepository.save(cinema);
 }

 public void delete (Cinema cinema){
    cinemaCrudRepository.delete(cinema);
 }

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinema.usaCiclo3.model.Cinema;
import com.cinema.usaCiclo3.repository.crud.CinemaCRUD;

@Repository
public class CinemaRepository {
    @Autowired
    private CinemaCRUD cinemaCrudRepository;
    
    public List<Cinema> getAll(){
        return (List<Cinema>) cinemaCrudRepository.findAll();
    }
    public Optional<Cinema> getCinema(int id){
        return cinemaCrudRepository.findById(id);
    }
    
    public Cinema save(Cinema c){
        return cinemaCrudRepository.save(c);
    }
}