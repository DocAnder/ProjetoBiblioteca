package com.example.agendaproject.controller;

import com.example.agendaproject.Dao.DaoLivro;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CreatNewBookServlet", value = "/CreatNewBookServlet")
public class CreatNewBookServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoLivro daoLivro = new DaoLivro();
        Boolean salvo = daoLivro.saveNewOne(request);
        if (salvo){
            response.sendRedirect("http://localhost:8080/AgendaProject/booksListServlet");
        }else{
            response.sendRedirect("http://localhost:8080/AgendaProject/creatBooks.jsp?msg=notSave");
        }

    }
}
