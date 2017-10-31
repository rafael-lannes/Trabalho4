<%@page import="br.DAO.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Cliente</title>
        <style>
        input:-moz-read-only { /* For Firefox */
            background-color: #DCDCDC;
        }

        input:read-only {
            background-color: #DCDCDC;
        }
        </style>
    </head>
    <body>
        <h1>Lista de Clientes</h1>
        <h1>Excluir Cliente</h1>
        <% Cliente cliente = (Cliente) request.getAttribute("Cliente"); 
        %>
        <form action="ExcluirCliente" method="Post">
            
            <input type="hidden" name="id" value="<%=cliente.getId()%>" >
            
            <% if(request.getAttribute("erro_nome") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Nome do Cliente:<br>
            <input type="text" name="nome" value="<%=cliente.getNome() %>" readonly="" >
            <br>
            <input type="submit" value="Confirmar Exclusão">
            <a href="ListaCliente">Retorna</a>
        </form> 
    </body>
</html>
