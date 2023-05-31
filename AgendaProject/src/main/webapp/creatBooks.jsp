<%@ page import="com.example.agendaproject.model.Livro" %>
<%@ page import="com.example.agendaproject.Dao.DaoLivro" %>
<%@ page import="com.example.agendaproject.Utils.DateFormater" %><%--
  Created by IntelliJ IDEA.
  User: Anderson
  Date: 21/05/2023
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <style>
    .container{
      margin-left: 30%;
      margin-right: 30%;
      padding: 20px;
    }
    h1{
      text-align: center;
    }
    .containerButton{
      width: 200px;
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
<div class="container">
  <form action="CreatNewBookServlet" method="post">
    <h1 class="h3 mb-3 fw-normal">Cadastro de Livro</h1>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="Livro Novo" name="bookName" value="">
      <label for="floatingInput">Titulo</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput2" placeholder="Autor" name="autorName">
      <label for="floatingInput2">Nome do Autor</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput3" placeholder="Indisponivel" name="status">
      <label for="floatingInput3">Status (Disponivel, Indisponivel, Emprestado)</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput4" placeholder="01/01/2010" name="date">
      <label for="floatingInput4">Data lançamento (dd/mm/yyyy)</label>
    </div>
    <div class="containerButton">
      <button class="w-100 btn btn-lg btn-primary" type="submit">Submit</button>
    </div>
    <p>NOTA: Caso o autor informado não esteja cadastrado, um novo será criado automaticamente.</p>
  </form>

</div>

</body>
</html>
