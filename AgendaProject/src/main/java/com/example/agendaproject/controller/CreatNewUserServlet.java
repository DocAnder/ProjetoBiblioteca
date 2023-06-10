package com.example.agendaproject.controller;

import com.example.agendaproject.Dao.DaoUser;
import com.example.agendaproject.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "CreatNewUserServlet", value = "/CreatNewUserServlet")
public class CreatNewUserServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();

        String userName = request.getParameter("userName");
        String userEmail = request.getParameter("userEmail");
        String userType = request.getParameter("userType");
        String userPassword = request.getParameter("userPassword");
        user.setName(userName);
        user.setEmail(userEmail);
        user.setType(userType);
        user.setPassword(userPassword);

        DaoUser daoUser = new DaoUser();
        daoUser.create(user);
        response.sendRedirect("http://localhost:8080/AgendaProject/booksListServlet");

    }
}
