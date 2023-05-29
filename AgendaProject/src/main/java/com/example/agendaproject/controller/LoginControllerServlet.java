package com.example.agendaproject.controller;

import com.example.agendaproject.Dao.DaoLivro;
import com.example.agendaproject.model.Livro;
import com.example.agendaproject.services.loginService.LoginChecker;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/LoginControllerServlet", "/login"})
public class LoginControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = req.getParameter("user");
        String password = req.getParameter("password");
        //System.out.println(user);
        //System.out.println(password);

        LoginChecker loginChecker = new LoginChecker();
        //DaoLivro daoLivro = new DaoLivro();

        try {
            loginChecker.loginValidate(user, password, req);
            //req.setAttribute("livros", daoLivro.listAll());
            //resp.sendRedirect("http://localhost:8080/AgendaProject/booksList.jsp");
            //RequestDispatcher requestDispatcher = req.getRequestDispatcher("booksList.jsp");
            //requestDispatcher.forward(req, resp);
            resp.sendRedirect("http://localhost:8080/AgendaProject/booksListServlet");


        }catch (Exception e){
            String msg = e.getMessage();
            resp.sendRedirect("http://localhost:8080/AgendaProject/index.jsp?msg=" + msg);
        }

        //resp.sendRedirect("http://localhost:8080/AgendaProject/booksList.jsp");

    }
}
