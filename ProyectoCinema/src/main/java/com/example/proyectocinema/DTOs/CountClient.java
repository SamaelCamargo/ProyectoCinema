package com.example.proyectocinema.DTOs;

import com.example.proyectocinema.model.Client;

public class CountClient {
    private long total;
    private Client client;

    public CountClient(Long aLong, Client client) {
        this.total = aLong;
        this.client = client;

    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
