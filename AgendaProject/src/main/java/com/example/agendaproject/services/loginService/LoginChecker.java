package com.example.agendaproject.services.loginService;

import com.example.agendaproject.Dao.DaoUser;
import com.example.agendaproject.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServlet;

public class LoginChecker {

    public void loginValidate(String user, String password, HttpServletRequest request) throws Exception {

        if(user.isEmpty() || user == null || password.isEmpty() || password == null){
            throw  new Exception("Preencha os campos com email e senha!");
        }else{
            User usuario = new User();
            DaoUser daoUser = new DaoUser();
            usuario = daoUser.getOne(user);
            if(user.equals(usuario.getEmail()) && password.equals(usuario.getPassword())){
                HttpSession session = request.getSession();
                session.setAttribute("is_logged_in", true);
                session.setAttribute("user", usuario);
            }else {
                throw new Exception("Usuario ou senha incorretos!");
            }
        }


        /*
        if(password.isEmpty() || password == null){
            throw  new Exception("Preencha os campos com email e senha!");
        }

        */
        /*
        if(user.equals("admin@admin") && password.equals("admin")){

            HttpSession session = request.getSession();
            session.setAttribute("is_logged_in", true);
            session.setAttribute("user", user);

        }else {
            throw new Exception("Usuario ou senha incorretos!");
        }

         */

    }



}
