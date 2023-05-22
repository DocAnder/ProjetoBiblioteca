package com.example.agendaproject.model;

public enum Status {

    DISPONIVEL, INDISPONIVEL, EMPRESTADO;

    private Integer id;
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
