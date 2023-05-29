package com.example.agendaproject.lists;

import com.example.agendaproject.Dao.DaoLivro;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "booksListServlet", value = "/booksListServlet")
public class booksListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        DaoLivro daoLivro = new DaoLivro();
        req.setAttribute("livros", daoLivro.listAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("booksList.jsp");
        requestDispatcher.forward(req, resp);

    }
}
