<%--
  Created by IntelliJ IDEA.
  User: Anderson
  Date: 30/05/2023
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.agendaproject.model.Livro" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.agendaproject.Utils.DateFormater" %>
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
        .caixa{
            margin-left: 30%;
            margin-right: 30%;
            padding: 20px;
            border-collapse: collapse; /* CSS2 */
            border: 1px solid black;

        }
        .bordas{
            border-bottom: 1px solid black;
            border-collapse: collapse; /* CSS2 */
            padding: 4px;
        }
    </style>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <title>Title</title>
</head>
<body>
<h1 class="center">Lista de Livros</h1>

<div class="caixa">
    <% for (int i = 0; i < livros.size(); i++) {%>
        <div>
            <a id=<%=i%> href="EditControllerServlet?codigo=<%= livros.get(i).getCodigo() %>" method="get" class="list-group-item " aria-current="true" onmouseenter="entrou(id)" onmouseleave="saiu(id)">
                <div class="d-flex w-100 justify-content-between ">
                    <h5 class="mb-1"><%= livros.get(i).getNome() %></h5>
                    <span class="badge bg-primary rounded-pill align-items-center"> <%= livros.get(i).getCodigo() %></span>
                    <% request.setAttribute("codigo", 1); %>
                </div>
                <p class="mb-1"> Autor: <%= livros.get(i).getAutor().getNome() %> | Data de Criação: <%= DateFormater.dateParaString(livros.get(i).getDate()) %> </p>
                <small>Status: <%= livros.get(i).getStatus() %></small>
            </a>
            <div class="dropdown">
                <button class="btn btn-primary dropdown-toggle btn-sm" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Alterar Situação
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="EditStatusControllerServlet?status=Disponivel&id=<%= livros.get(i).getCodigo() %>">Disponivel</a></li>
                    <li><a class="dropdown-item" href="EditStatusControllerServlet?status=Indisponivel&id=<%= livros.get(i).getCodigo() %>">Indisponivel</a></li>
                    <li><a class="dropdown-item" href="EditStatusControllerServlet?status=Emprestado&id=<%= livros.get(i).getCodigo() %>">Emprestado</a></li>
                </ul>
                <button type="button" class="btn btn-warning btn-sm">Deletar</button>
                <p class="bordas"></p>

        </div>

    <%}%>
</div>

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




</body>
</html>
