package com.example.agendaproject.Utils;

import com.example.agendaproject.Dao.DaoLivro;
import com.example.agendaproject.Dao.DaoUser;
import com.example.agendaproject.model.Livro;
import com.example.agendaproject.model.User;

import java.util.ArrayList;

public class Tester {

    public static void main(String[] args) {


        DaoUser daoUser = new DaoUser();

        User user = new User();

        user.setName("Anderson");
        user.setEmail("anderson@gmail.com");
        user.setPassword("12345");
        user.setType("regular");

        daoUser.create(user);










    }

}
