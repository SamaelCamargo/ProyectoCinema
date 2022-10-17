package com.example.proyectocinema.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idScore;
    private String messageText;
    private Integer starts;

    //se agrega:

    @OneToOne
    @JsonIgnoreProperties("score")
    private Reservation reservation;

    public Score() {
    }

    public Score(Integer idScore, String messageText, Integer starts) {
        this.idScore = idScore;
        this.messageText = messageText;
        this.starts = starts;
    }

    public Score(Integer starts) {
        this.starts = starts;
    }
    //fin

    public Integer getIdScore() {
        return idScore;
    }

    public void setIdSore(Integer idSore) {
        this.idScore = idSore;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Integer getStarts() {
        return starts;
    }

    public void setStarts(Integer starts) {
        this.starts = starts;
    }

    public Reservation getReservation() {
        return reservation;
    }

    //se agrega:
    public void setReservation(Reservation reservations) {
        this.reservation = reservations;
    }
    //final
}
