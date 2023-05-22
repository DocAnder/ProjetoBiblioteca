package com.example.agendaproject.model;


import java.util.Date;

public class Livro {

    private Integer id;
    private String nome;
    private Date date;
    private Autor autor;
    private Enum<Status> status;

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public Autor getAutor() {
        return autor;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Enum<Status> getStatus() {
        return status;
    }
    public void setStatus(Enum<Status> status) {
        this.status = status;
    }
    public Integer getCodigo() {
        return id;
    }
    public void setCodigo(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
