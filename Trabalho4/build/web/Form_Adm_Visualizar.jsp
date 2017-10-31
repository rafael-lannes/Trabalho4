<%@page import="br.DAO.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar</title>
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
        <h1>Lista de ADMS</h1>
        <h1>Dados do ADM</h1>
        <% Administrador adm = (Administrador) request.getAttribute("adm"); 
        %>
        <form action="ListaADM" method="GET">
            
            <input type="hidden" name="id" value="<%=adm.getId()%>" >
            
            <% if(request.getAttribute("erro_nome") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Login:<br>
            <input type="text" name="login" value="<%=adm.getLogin() %>" readonly="true" >
            <br>
            <% if(request.getAttribute("erro_idade") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_idade"));%></h3>        
            <% }%>
            Senha:<br>
            <input type="text" name="senha" value="<%=adm.getSenha()%>" readonly="true" >
            <br><br>
            <a href="ListaADM">Retornar</a>
        </form> 
    </body>
</html>