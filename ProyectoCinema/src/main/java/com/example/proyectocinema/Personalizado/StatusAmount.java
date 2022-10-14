package com.example.proyectocinema.Personalizado;

public class StatusAmount {
    private int completed;
    private int cancelled;

    public StatusAmount(int size, int size1) {
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
}
