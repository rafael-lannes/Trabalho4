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
        <title>Página para incluir um Cliente Novo</title>
    </head>
    <body>
        <h1>Insira as informaçoes do Cliente:</h1>
        <form action="IncluirCliente" method="POST">
        ID: <input type="int" name="id"><br>
        Nome: <input type="text" name="nome"><br>
        Endereço: <input type="text" name="endereco"><br>
        Bairro: <input type="text" name="bairro"><br>
        Cidade: <input type="text" name="cidade"><br>
        CEP: <input type="long" name="cep"><br>
        Estado: <input type="text" name="estado"><br>        
        Referencia: <input type="text" name="referencia"><br>
        CPF: <input type="long" name="cpf"><br>
        RG: <input type="long" name="rg"><br>        
        TEL: <input type="long" name="tel"><br>
        CEL: <input type="long" name="cel"><br>
        CARTAO: <input type="long" name="credito"><br>        
        BANDEIRA: <input type="text" name="bandeira"><br>          
        <input type="submit" value="Submit">
</form>
    </body>
</html>
