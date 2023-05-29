package com.example.agendaproject.Utils;

import com.example.agendaproject.Dao.DaoLivro;
import com.example.agendaproject.model.Livro;

import java.util.ArrayList;

public class Tester {

    public static void main(String[] args) {

        DaoLivro daoLivro = new DaoLivro();

        int id = daoLivro.getIdAutor("J.K");
        System.out.println(id);

        id = daoLivro.getIdAutor("Gepeto");
        System.out.println(id);








    }

}
