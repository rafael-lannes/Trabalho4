<%@page import="br.DAO.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página para Editar um Cliente</title>
    </head>
    <body>
        <h1>Insira as informaçoes do Cliente:</h1>
        <% Cliente cliente = (Cliente) request.getAttribute("Cliente"); 
        %>
        <form action="EditarCliente" method="POST">
        ID: <input type="hidden" name="id" value="<%=cliente.getId()%>" ><br>
        
        Nome: <input type="text" name="nome" value="<%=cliente.getNome()%>"><br>
        
        Endereço: <input type="text" name="endereco" value="<%=cliente.getEndereco()%>"><br>
        
        Bairro: <input type="text" name="bairro" value="<%=cliente.getBairro()%>"><br>
        
        Cidade: <input type="text" name="cidade" value="<%=cliente.getCidade()%>"><br>
        
        CEP: <input type="long" name="CEP" value="<%=cliente.getCEP()%>"><br>
        
        Estado: <input type="text" name="estado" value="<%=cliente.getEstado()%>"><br>  
        
        Referencia: <input type="text" name="referencia" value="<%=cliente.getReferencia()%>"><br>
        
        CPF: <input type="long" name="cpf" value="<%=cliente.getCPF()%>"><br>
        
        RG: <input type="long" name="rg" value="<%=cliente.getRG()%>"><br>   
        
        TEL: <input type="long" name="tel" value="<%=cliente.getTel()%>"><br>
        
        CEL: <input type="long" name="cel" value="<%=cliente.getCel()%>"><br>
        
        CARTAO: <input type="long" name="credito" value="<%=cliente.getCartao()%>"><br>   
        
        BANDEIRA: <input type="text" name="bandeira" value="<%=cliente.getBandeira()%>"><br>    
        
        <input type="submit" value="Alterar">
        
        <a href="PainelDeControle.jsp">Retornar</a>
</form>
    </body>
</html>