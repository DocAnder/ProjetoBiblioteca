<%--
  Created by IntelliJ IDEA.
  User: Anderson
  Date: 17/05/2023
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.agendaproject.model.Livro" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<%
  Boolean logado = (Boolean) session.getAttribute("is_logged_in");
  if(logado == null || logado == false){
    response.sendRedirect("http://localhost:8080/AgendaProject/index.jsp");
  }

  ArrayList<Livro> livros = (ArrayList<Livro>) request.getAttribute("livros");
  //String livro1 = livros.get(1).getNome();
  //System.out.println(livro1);
%>
<html>
<head>
  <style>
    .container{
      margin-left: 1000px;
      margin-right: 1000px;
      padding: 20px;
    }
    h1{
      text-align: center;
    }
  </style>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
        rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<h1>Lista de Livros</h1>
<div class="container">
  <div class="list-group">
    <% for (int i = 0; i < livros.size(); i++) {%>
        <a id=<%=i%> href="EditBook?id=<%= livros.get(i).getCodigo() %>" class="list-group-item" aria-current="true" onmouseenter="entrou(id)" onmouseleave="saiu(id)">
          <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1"><%= livros.get(i).getNome() %></h5>
            <small><%= livros.get(i).getStatus() %></small>
          </div>
          <p class="mb-1">Autor: <%= livros.get(i).getAutor() %> | Código:<%= livros.get(i).getCodigo() %> </p>
          <small>Data de criação: <%= livros.get(i).getDataCriacao() %></small>
        </a>
    <%}%>
  </div>
</div>
</body>
<script>


  function entrou(num){
    let a = document.getElementById(num);
    a.style.background = '#AFD6F8'
  }

  function saiu(num){
    let a = document.getElementById(num);
    a.style.background = 'white'
  }

</script>
</html>

