<%@page import="br.DAO.Cliente"%>
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
        <% Cliente cliente = (Cliente) request.getAttribute("Cliente"); 
        %>
        <form action="ListaCliente" method="GET">
            
            <input type="hidden" name="id" value="<%=cliente.getId()%>" >
            Nome:<br>
            <input type="text" name="nome" value="<%=cliente.getNome() %>" readonly="true" >
            <br>
            Endereço:<br>
            <input type="text" name="endereço" value="<%=cliente.getEndereco() %>" readonly="true" >
            <br>
            Bairro:<br>
            <input type="text" name="bairro" value="<%=cliente.getBairro() %>" readonly="true" >
            <br>
            Cidade:<br>
            <input type="text" name="cidade" value="<%=cliente.getCidade() %>" readonly="true" >
            <br>
            CEP:<br>
            <input type="text" name="cep" value="<%=cliente.getCEP() %>" readonly="true" >
            <br>
            Estado:<br>
            <input type="text" name="estado" value="<%=cliente.getEstado() %>" readonly="true" >
            <br>
            Referencia:<br>
            <input type="text" name="referencia" value="<%=cliente.getReferencia() %>" readonly="true" >
            <br>
            CPF:<br>
            <input type="text" name="cpf" value="<%=cliente.getCPF() %>" readonly="true" >
            <br>
            RG:<br>
            <input type="text" name="rg" value="<%=cliente.getRG() %>" readonly="true" >
            <br>
            TEL:<br>
            <input type="text" name="tel" value="<%=cliente.getTel() %>" readonly="true" >
            <br>
            CEL:<br>
            <input type="text" name="cel" value="<%=cliente.getCel() %>" readonly="true" >
            <br>            
            CARTAO:<br>
            <input type="text" name="cartao" value="<%=cliente.getCartao() %>" readonly="true" >
            <br>
            BANDEIRA DO CARTAO:<br>
            <input type="text" name="bandeira" value="<%=cliente.getBandeira()%>" readonly="true" >
            <br><br>
            <a href="ListaCliente">Retornar</a>
        </form> 
    </body>
</html>