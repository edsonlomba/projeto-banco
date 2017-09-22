<%-- 
    Document   : remove_conta
    Created on : 15/09/2017, 20:29:52
    Author     : Edson Lomba - 41525388
--%>
<%@page import="bancodao.ContaDaoRelacional"%>
<%@page import="bancodao.ContaDaoInterface"%>
<%@page import="bancodao.ConexaoJavaDb"%>
<%@page import="bancodao.ConexaoInterface"%>
<%@page import="bancodao.Conta"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Conta</title>
    </head>
    <body>
        <a href="checkout.jsp"><p style="font-family:verdana;font-size:12px">Efetuar Logoff</p></a>
        
        <p style="font-family:verdana;font-weight:bold;font-size:16px">Conta removida com sucesso!</p>
        <%
            List<Conta> contas = (List<Conta>) request.getAttribute("lista_contas");
        %>
        <%if (contas.size() > 0) { %>
        <table style="font-family:verdana;font-size:12px">
            <tr>
                <td width="100pixels">Número</td>
                <td width="100pixels">Saldo da conta</td>
            </tr>
            <% for (Conta c : contas) {%>
            <tr>
                <td><%=c.getNumero()%></td>
                <td>R$ <%=c.getSaldo()%></td>
            </tr>
            <%}%>
        </table>
        <%}%>
        <br>
        <a href="index.html" style="font-family:verdana;font-size:12px">Voltar</a>
    </body>
</html>
