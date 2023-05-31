package com.example.agendaproject.Dao;

import com.example.agendaproject.ConnectionFactory.ConnectionMaker;
import com.example.agendaproject.Utils.DateFormater;
import com.example.agendaproject.model.Autor;
import com.example.agendaproject.model.Livro;
import com.example.agendaproject.model.Status;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class DaoLivro {

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

    //LISTALL TESTADA E FUNCIONAL
    public ArrayList<Livro> listAll(){
        ArrayList<Livro> allBooks = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            this.conectar();
            //("SELECT * FROM tb_clientes_pj as c, tb_enderecos_pj as e WHERE c.cod_cli_pj = e.cod_cli_pj ORDER BY c.nome;");
            String comando = "SELECT * from Livros as livro, Autores as autor WHERE livro.autor_id = autor.id ORDER BY autor.nome;";
            resultSet = st.executeQuery(comando);
            while (resultSet.next()){
                Livro livro = new Livro();
                Autor autor = new Autor();
                livro.setCodigo(resultSet.getInt("id"));
                livro.setNome(resultSet.getString("titulo"));
                livro.setStatus(Status.valueOf(resultSet.getString("status_livro").toUpperCase()));
                livro.setDate(resultSet.getDate("ano_publicacao"));
                autor.setId(resultSet.getInt("autor_id"));
                autor.setNome(resultSet.getString("nome"));
                livro.setAutor(autor);
                allBooks.add(livro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            // CASO CHAME A FUNÇÃO DESCONECTAR QUE EXECUTA O CLOSE NA CONN E NO ST, NÃO FUNCIONA OS DEMAIS METODOS
            // MSG DO ERRO: No operations allowed after connection closed.
            //SOLUÇÃO: ESTAVA ENCERRANDO A CONEXÃO CONN. PASSEI A ENCERRAR SOMENTE O RESULTSET E O ST.
            //MAIS NAO POSSO ABRIR E FECHAR A CONN?
            this.desconectar(resultSet, st);
        }
        return allBooks;
    }

    //GETONE TESTADA E FUNCIONAL
    public Livro getOne(Integer id){
        Livro livro;
        ResultSet resultSet = null;
        String comando = "SELECT * from Livros as livro, Autores as autor WHERE livro.id = " + id + " and livro.autor_id = autor.id;";
        this.conectar();
        try {
            resultSet = st.executeQuery(comando);
            livro = fillOne(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            this.desconectar(resultSet, st);
        }
        return livro;
    }

    //SAVEONE TESTADA E FUNCIONAL
    public boolean saveOne(HttpServletRequest req){
        Boolean result = false;
        String id = req.getParameter("codigo");
        String bookName = req.getParameter("bookName");
        String autorName = req.getParameter("autorName");
        String status = req.getParameter("status");
        String data = req.getParameter("date");

        int idAutor = 0;
        if (!this.findAutor(autorName)) {
            this.saveNewAutor(autorName);
        }
        idAutor = this.getIdAutor(autorName);
        this.conectar();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(
                    "UPDATE Livros SET titulo = ?, status_livro = ?, ano_publicacao = ?, autor_id = ? WHERE id = ?"
                    );
            pst.setString(1, bookName);
            pst.setString(2, status);
            pst.setString(3, DateFormater.stringToSqlFormat(data));
            pst.setString(5, id);
            pst.setInt(4, idAutor);
            pst.executeUpdate();
            result = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public boolean saveOne(Livro livro){
        Boolean save = false;

        this.conectar();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(
                    "UPDATE Livros SET titulo = ?, status_livro = ?, ano_publicacao = ?, autor_id = ? WHERE id = ?"
            );
            pst.setString(1, livro.getNome());
            pst.setString(2, livro.getStatus().toString());
            pst.setString(3, DateFormater.stringToSqlFormat(DateFormater.dateParaString(livro.getDate())));
            pst.setInt(5, livro.getCodigo());
            pst.setInt(4, livro.getAutor().getId());
            pst.executeUpdate();
            save = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return save;
    }

    public  boolean saveNewOne(HttpServletRequest req){
        Boolean retorno = false;
        int idAutor = 0;

        String bookName = req.getParameter("bookName");
        String autorName = req.getParameter("autorName");
        String status = req.getParameter("status");
        String data = req.getParameter("date");

        if (!this.findAutor(autorName)) {
            this.saveNewAutor(autorName);
        }
        idAutor = this.getIdAutor(autorName);

        this.conectar();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(
                    "INSERT INTO Livros (id, titulo, ano_publicacao, status_livro, autor_id) VALUES (NULL,?,?,?,?)"
            );
            pst.setString(1, bookName);
            pst.setString(2, DateFormater.stringToSqlFormat(data));
            pst.setString(3, status);
            pst.setInt(4, idAutor);
            pst.executeUpdate();
            retorno = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return retorno;
    }

    //FINDAUTOR TESTADA E FUNCIONAL
    public boolean findAutor(String nome){
        boolean find = false;
        String comando = "SELECT * FROM Autores WHERE nome = " + "'" + nome + "'";
        this.conectar();
        try {
            ResultSet resultSet = st.executeQuery(comando);
            if (resultSet.next()){
                find = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return find;
    }

    public int getIdAutor(String nome){
        int id = -1;
        String comando = "SELECT * FROM Autores WHERE nome = " + "'" + nome + "'";
        this.conectar();

        try {
            ResultSet resultSet = st.executeQuery(comando);
            if (resultSet.next()){
                id = resultSet.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return id;
    }

    //SAVENEWAUTOR TESTADA E FUNCIONAL
    public void saveNewAutor(String nome){
        Autor autor = new Autor();
        String comando = "INSERT INTO Autores (id, nome) VALUES (NULL," + "'" + nome + "'" + ");";
        //System.out.println(comando);
        this.conectar();
        try {
            st.executeUpdate(comando);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //FILLONE TESTADA E FUNCIONAL
    public Livro fillOne(ResultSet resultSet){
        Livro livro = new Livro();
        Autor autor = new Autor();
        try {
            if (resultSet.next()){
                livro.setCodigo(resultSet.getInt("id"));
                livro.setNome(resultSet.getString("titulo"));
                livro.setStatus(Status.valueOf(resultSet.getString("status_livro").toUpperCase()));
                livro.setDate(resultSet.getDate("ano_publicacao"));
                autor.setId(resultSet.getInt("autor_id"));
                autor.setNome(resultSet.getString("nome"));
                livro.setAutor(autor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return livro;
    }

    public void deleteOne(Integer id){
        this.conectar();
        PreparedStatement pst = null;

        try {
            pst = conn.prepareStatement(
                    "DELETE FROM Livros WHERE id = ?;"
            );
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
