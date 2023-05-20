package com.example.agendaproject.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.agendaproject.Dao.DaoLivro;

import java.io.IOException;

@WebServlet(urlPatterns = {"/EditBook"})
public class EditControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String id2 = req.getParameter("id");
        System.out.println(id2);


        //resp.sendRedirect("http://localhost:8080/AgendaProject/booksList.jsp");
        DaoLivro daoLivro = new DaoLivro();
        req.setAttribute("livros", daoLivro.listAll());
        //resp.sendRedirect("http://localhost:8080/AgendaProject/booksList.jsp");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("booksList.jsp");
        requestDispatcher.forward(req, resp);

    }
}
