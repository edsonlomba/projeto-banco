<%-- 
    Document   : adiciona_conta
    Created on : 08/09/2017, 23:44:02
    Author     : Edson Lomba - 41525388
--%>

<%@page import="bancodao.ContaDaoRelacional"%>
<%@page import="bancodao.ContaDaoInterface"%>
<%@page import="bancodao.ConexaoJavaDb"%>
<%@page import="bancodao.ConexaoInterface"%>
<%@page import="bancodao.Conta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Localiza Contas</title>
    </head>
    <body>
        <a href="checkout.jsp"><p style="font-family:verdana;font-size:12px">Efetuar Logoff</p></a>
        
        <p style="font-family:verdana;font-weight:bold;font-size:16px">Conta encontrada</p>
        <%
            Conta conta = (Conta) request.getAttribute("retorno");
        %>
        <table style="font-family:verdana;font-size:12px">
            <tr>
                <td width="100pixels">Número</td>
                <td width="100pixels">Saldo da conta</td>
            </tr>
            <tr>
                <td><%=conta.getNumero()%></td>
                <td>R$ <%=conta.getSaldo()%></td>
            </tr>
        </table>
        <br>
        <a href="index.html" style="font-family:verdana;font-size:12px">Voltar</a>
    </body>
</html>
