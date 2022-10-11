package com.example.proyectocinema.Repository.Crud;

import com.example.proyectocinema.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
