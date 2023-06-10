package com.example.agendaproject.Dao;

import com.example.agendaproject.ConnectionFactory.ConnectionMaker;
import com.example.agendaproject.Utils.DateFormater;
import com.example.agendaproject.model.User;

import java.sql.*;

public class DaoUser {

    private Connection conn;
    private Statement st;

    private void conectar(){
        try {
            this.conn = ConnectionMaker.getConnection();
            st = conn.createStatement();
        } catch (SQLException e2){
            System.out.println(e2.getMessage());
        }
    }
    private void desconectar(ResultSet resultSet, Statement st){
        ConnectionMaker.resultSetClose(resultSet);
        ConnectionMaker.statementClose(st);
    }

    public User getOne(String email){
        User usuario;
        ResultSet resultSet = null;
        String comando = "SELECT * from Usuarios WHERE email = '" + email + "';";
        System.out.println(comando);
        this.conectar();
        try {
            resultSet = st.executeQuery(comando);
            usuario = fillOne(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            this.desconectar(resultSet, st);
        }
        return usuario;
    }

    public User fillOne(ResultSet resultSet){
        User usuario = new User();
        try {
            if (resultSet.next()){
                usuario.setId(resultSet.getString("id"));
                usuario.setName(resultSet.getString("nome"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setPassword(resultSet.getString("senha"));
                usuario.setType(resultSet.getString("tipo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }


    public void create(User usuario){

        this.conectar();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(
                    "INSERT INTO Usuarios (id, nome, email, senha, tipo) VALUES (NULL,?,?,?,?)"
            );
            pst.setString(1, usuario.getName());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getPassword());
            pst.setString(4, usuario.getType());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }




}
