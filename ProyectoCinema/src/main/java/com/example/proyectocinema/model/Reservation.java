package com.example.proyectocinema.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";

    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"reservations"})
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private Client client;

    //se agrega
    @OneToOne(mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;
    //final


    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    //se agrega
    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
    //final
}
