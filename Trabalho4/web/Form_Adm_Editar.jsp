<%@page import="br.DAO.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Administrador</title>
    </head>
    <body>
        <h1>Lista de Adms</h1>
        <h1>Alterar Dados do Adm</h1>
        <% Administrador adm = (Administrador) request.getAttribute("adm"); 
        %>
        <form action="EditarADM" method="POST">
            
            <input type="hidden" name="id" value="<%=adm.getId()%>" >
            
            <% if(request.getAttribute("erro_nome") != null){ %> 
                 <h3 style="color:Tomato;"><% out.print(request.getAttribute("erro_nome"));%></h3>        
            <% }%>
            Login:<br>
            <input type="text" name="login" value="<%=adm.getLogin()%>" >
            <br>
            Senha:<br>
            <input type="text" name="senha" value="<%=adm.getSenha()%>" >
            <br><br>
            <input type="submit" value="Alterar">
            <a href="PainelDeControle.jsp">Retornar</a>
        </form> 
    </body>
</html>