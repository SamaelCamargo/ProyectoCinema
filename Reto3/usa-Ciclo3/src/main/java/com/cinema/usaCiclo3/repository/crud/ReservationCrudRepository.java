package com.cinema.usaCiclo3.repository.crud;

import com.cinema.usaCiclo3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
