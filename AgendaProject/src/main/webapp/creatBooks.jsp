<%@ page import="com.example.agendaproject.model.Livro" %><%--
  Created by IntelliJ IDEA.
  User: Anderson
  Date: 21/05/2023
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

  Livro livro = (Livro) request.getAttribute("livro");
  String nome = livro.getNome();
  System.out.println(nome);

%>
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
  <form action="" method="post">
    <h1 class="h3 mb-3 fw-normal">Cadastro de Livro</h1>

    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput" placeholder="nome" name="bookName">
      <label for="floatingInput">book name</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingInput2" placeholder="autor" name="autorName">
      <label for="floatingInput2">autors name</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
      <label for="floatingPassword">Password</label>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
  </form>

</div>

</body>
</html>
