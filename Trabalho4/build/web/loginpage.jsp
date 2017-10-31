<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Application</title>
</head>
<body>
    <form action="VerificarLogin" method="post">
        <fieldset style="width: 300px">
            <legend> Login</legend>
            <table>
                <tr>
                    <td>Usuario</td>
                    <td><input type="text" name="login" required="required" /></td>
                </tr>
                <tr>
                    <td>Senha</td>
                    <td><input type="password" name="senha" required="required" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login" /></td>
                </tr>
            </table>
        </fieldset>
    </form>
</body>
</html>