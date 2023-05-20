package com.example.agendaproject.Dao;

import com.example.agendaproject.model.Livro;
import com.example.agendaproject.model.Status;

import java.util.ArrayList;

public class DaoLivro {

    public ArrayList<Livro> listAll(){
        ArrayList<Livro> allBooks = new ArrayList<>();

        Livro livro = new Livro();
        Livro livro2 = new Livro();
        Livro livro3 = new Livro();

        livro.setCodigo(1);
        livro.setNome("A GRANDE ONDA");
        livro.setAutor("Silver Gold");
        livro.setDataCriacao("13/10/2010");
        livro.setStatus(Status.DISPONIVEL);

        livro2.setCodigo(2);
        livro2.setNome("HARRY POTTER");
        livro2.setAutor("J. K. Rowling");
        livro2.setDataCriacao("09/04/2021");
        livro2.setStatus(Status.EMPRESTADO);

        livro3.setCodigo(3);
        livro3.setNome("INSONIA");
        livro3.setAutor("Sthepen King");
        livro3.setDataCriacao("03/10/2019");
        livro3.setStatus(Status.INDISPONIVEL);

        allBooks.add(livro);
        allBooks.add(livro2);
        allBooks.add(livro3);

        return allBooks;
    }

}
