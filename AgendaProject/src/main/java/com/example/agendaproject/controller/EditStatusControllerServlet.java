package com.example.agendaproject.controller;

import com.example.agendaproject.Dao.DaoLivro;
import com.example.agendaproject.model.Livro;
import com.example.agendaproject.model.Status;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditStatusControllerServlet", value = "/EditStatusControllerServlet")
public class EditStatusControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        System.out.println("ID OBTIDO: " + id);
        String status = request.getParameter("status");
        System.out.println("STATUS OBTIDO: " + status.toUpperCase());
        DaoLivro daoLivro = new DaoLivro();
        Livro livro = daoLivro.getOne(Integer.parseInt(id));
        System.out.println(livro);
        livro.setStatus(Status.valueOf(status.toUpperCase()));
        System.out.println(livro);
        daoLivro.saveOne(livro);
        response.sendRedirect("http://localhost:8080/AgendaProject/booksListServlet");
    }


}
