package com.example.agendaproject.controller;

import com.example.agendaproject.Dao.DaoLivro;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteBookControllerServlet", value = "/DeleteBookControllerServlet")
public class DeleteBookControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String status = request.getParameter("status");
        System.out.println("ID" + id);
        System.out.println("STATUS" + status);
        if(status.equals("INDISPONIVEL")){
            DaoLivro daoLivro = new DaoLivro();
            daoLivro.deleteOne(Integer.parseInt(id));
            response.sendRedirect("http://localhost:8080/AgendaProject/booksListServlet");
        }else{
            response.sendRedirect("http://localhost:8080/AgendaProject/booksListServlet?msg=notAllowed");
        }


    }


}
