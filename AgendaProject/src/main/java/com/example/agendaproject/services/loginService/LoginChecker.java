package com.example.agendaproject.services.loginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;

public class LoginChecker {

    public void loginValidate(String user, String password, HttpServletRequest request) throws Exception {

        if(user.isEmpty() || user == null){
            throw  new Exception("Usuário Inválido!");
        }

        if(password.isEmpty() || password == null){
            throw  new Exception("Senha Inválida!");
        }

        if(user.equals("admin@admin") && password.equals("admin")){

            HttpSession session = request.getSession();
            session.setAttribute("is_logged_in", true);
            session.setAttribute("user", user);

        }else {
            throw new Exception("Usuário ou senha incorretos!");
        }

    }



}
