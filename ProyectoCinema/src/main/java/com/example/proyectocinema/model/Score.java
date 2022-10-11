package com.example.proyectocinema.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSore;
    private String messageText;
    private Integer starts;


    public Integer getIdSore() {
        return idSore;
    }

    public void setIdSore(Integer idSore) {
        this.idSore = idSore;
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
    
}
