package com.example.proyectocinema.Services;

import com.example.proyectocinema.Repository.ReservationRepository;

import com.example.proyectocinema.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);}

    public Reservation save (Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservation1 = reservationRepository.getReservation(reservation.getIdReservation());
            if (reservation1.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }
    //RETO 4
    public Reservation update (Reservation reservation){
        if (reservation.getIdReservation()!=null){
            Optional<Reservation>reservation1=reservationRepository.getReservation(reservation.getIdReservation());
            if (!reservation1.isEmpty()){

                if(reservation.getStartDate()!=null){
                    reservation1.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    reservation1.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus()!=null){
                    reservation1.get().setStatus(reservation.getStatus());

                }
                reservationRepository.save(reservation1.get());
                return reservation1.get();
            }else {
                return reservation;
            }
        }else {
            return reservation;
        }
    }
    public boolean deleteReservation(int id){
        Boolean delete =getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return delete;
    }


}