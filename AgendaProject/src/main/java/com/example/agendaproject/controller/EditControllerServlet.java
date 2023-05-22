package com.example.agendaproject.controller;

import com.example.agendaproject.Dao.DaoLivro;
import com.example.agendaproject.model.Livro;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditControllerServlet", value = "/EditControllerServlet")
public class EditControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("codigo");
        System.out.println("Parameter: " + id);
        DaoLivro daoLivro = new DaoLivro();

        //Como enviar dados ou objetos anexados na response?
        request.setAttribute("livro", daoLivro.getOne(48));
        response.sendRedirect("http://localhost:8080/AgendaProject/creatBooks.jsp");
    }


}
