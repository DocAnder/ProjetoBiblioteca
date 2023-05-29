package com.example.agendaproject.ConnectionFactory;

import java.sql.*;

public class ConnectionMaker {

    private static Connection conn;

    public static Connection getConnection(){
        try {

            if(conn == null){
                //com.mysql.cj.jdbc.Driver
                // com.mysql.jdbc.Driver DEPRECATED
                Class.forName("com.mysql.cj.jdbc.Driver"); //nessário para conexões em aplicações web
                conn = DriverManager.getConnection("jdbc:mysql://localhost/bd_biblioteca?useTimezone=true&serverTimezone=UTC", "root", "bel468608");
            }
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void statementClose(Statement statement){
        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void resultSetClose(ResultSet resultSet){
        try {
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }




}
