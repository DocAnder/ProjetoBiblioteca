package com.example.agendaproject.Utils;

import com.example.agendaproject.Dao.DaoLivro;
import com.example.agendaproject.Dao.DaoUser;
import com.example.agendaproject.model.Livro;
import com.example.agendaproject.model.User;

import java.util.ArrayList;

public class Tester {

    public static void main(String[] args) {


        DaoUser daoUser = new DaoUser();

        User user = daoUser.getOne("a@admin");


        System.out.println(user.getName() + "  " + user.getEmail() + " " + user.getType());







    }

}
