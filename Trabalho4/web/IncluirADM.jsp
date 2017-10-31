<%-- 
    Document   : IncluirADM
    Created on : 30/10/2017, 14:06:52
    Author     : rafae
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página para incluir um adm novo</title>
        
    </head>
    <body>
        <h1>Insira as informaçoes do novo adm:</h1>
        <form action="IncluirADM" method="POST">
        ID: <input type="text" name="id"><br>
        Login: <input type="text" name="login"><br>
        Senha: <input type="password" name="senha"><br>
        <input type="submit" value="Submit">
</form>
    </body>
</html>
