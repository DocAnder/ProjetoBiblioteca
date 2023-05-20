package com.example.agendaproject.ConnectionFactory;

import java.sql.*;

public class ConnectionMaker {

    private static Connection conn;

    public static Connection getConnection(){
        try {

            if(conn == null){
                Class.forName("com.mysql.jdbc.Driver"); //nessário para conexões em aplicações web
                conn = DriverManager.getConnection("jdbc:mysql://localhost/dbagenda", "root", "bel468608");
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
