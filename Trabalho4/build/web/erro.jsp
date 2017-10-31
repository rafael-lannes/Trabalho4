<%-- 
    Document   : erro
    Created on : 30/10/2017, 14:44:30
    Author     : rafae
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% System.out.print(request.getAttribute("erro"));     %>
        <title>Erro!</title>
    </head>
    <body>
        <a href="PainelDeControle.jsp">Voltar ao Painel de Controle</a>
    </body>
</html>