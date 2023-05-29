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
        response.sendRedirect("http://localhost:8080/AgendaProject/editBook.jsp?id=" + id);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DaoLivro daoLivro = new DaoLivro();
        Boolean retorno = daoLivro.saveOne(req);
        System.out.println("SALVOU O LIVRO? " + retorno);
        resp.sendRedirect("http://localhost:8080/AgendaProject/booksListServlet");

    }
}
