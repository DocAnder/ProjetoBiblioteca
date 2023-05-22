package com.example.agendaproject.Dao;

import com.example.agendaproject.Utils.DateFormater;
import com.example.agendaproject.model.Autor;
import com.example.agendaproject.model.Livro;
import com.example.agendaproject.model.Status;

import java.util.ArrayList;
import java.util.Date;

public class DaoLivro {

    public ArrayList<Livro> listAll(){
        ArrayList<Livro> allBooks = new ArrayList<>();

        Livro livro = new Livro();
        Livro livro2 = new Livro();
        Livro livro3 = new Livro();

        Autor autor = new Autor();
        Autor autor2 = new Autor();
        Autor autor3 = new Autor();

        autor.setNome("Silver Gold");
        autor.setId(55);

        autor2.setNome("Pedro Cabral");
        autor2.setId(22);

        autor3.setNome("Bala Amarga");
        autor3.setId(10);



        livro.setCodigo(1);
        livro.setNome("A GRANDE ONDA");
        livro.setAutor(autor);
        livro.setDate(DateFormater.stringParaData("15/05/1989"));
        livro.setStatus(Status.DISPONIVEL);

        livro2.setCodigo(2);
        livro2.setNome("HARRY POTTER");
        livro2.setAutor(autor2);
        livro2.setDate(DateFormater.stringParaData("13/10/1999"));
        livro2.setStatus(Status.EMPRESTADO);

        livro3.setCodigo(3);
        livro3.setNome("INSONIA");
        livro3.setAutor(autor3);
        livro3.setDate(DateFormater.stringParaData("14/15/2021"));
        livro3.setStatus(Status.INDISPONIVEL);

        allBooks.add(livro);
        allBooks.add(livro2);
        allBooks.add(livro3);

        return allBooks;
    }


    public Livro getOne(Integer id){

        Livro livro = new Livro();
        Autor autor = new Autor();

        autor.setNome("Silver Gold");
        autor.setId(55);

        livro.setCodigo(id);
        livro.setNome("A GRANDE ONDA");
        livro.setAutor(autor);
        livro.setDate(DateFormater.stringParaData("15/05/1989"));
        livro.setStatus(Status.DISPONIVEL);

        return livro;
    }

}
