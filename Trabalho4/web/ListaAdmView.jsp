<%@page import="java.util.ArrayList"%>
<%@page import="br.DAO.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ver Adms</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <body>
        <h1>Lista de Administradores:</h1>
        <a href="IncluirADM.jsp">Incluir ADM</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Login</th>
            <th>Ações</th>
        </thead>
        <%
            ArrayList<Administrador> resultado = (ArrayList) request.getAttribute("meusADM");
            for (int i = 0; i < resultado.size(); i++) {
                Administrador aux = (Administrador)resultado.get(i);
        %>
        <tr>
        <td><%=aux.getId()%></td>
        <td><%=aux.getLogin()%></td> 
        <td><a href="VisualizarADM?id=<%=aux.getId()%>">Visualizar</a> | <a href="EditarADM?id=<%=aux.getId()%>">Editar</a> | <a href="ExcluirADM?id=<%=aux.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>
        <a href="PainelDeControle.jsp">Voltar para o Painel de Controle</a>

</body>
</html>
