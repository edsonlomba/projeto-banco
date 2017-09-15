<%-- 
    Document   : insere_conta
    Created on : 15/09/2017, 20:29:19
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
        <title>Insere Conta</title>
    </head>
    <body>
        <h1>Conta inserida com sucesso!</h1>
        <%
            List<Conta> contas = (List<Conta>) request.getAttribute("lista_contas");
        %>
        <%if (contas.size() > 0) { %>
        <table>
            <% for (Conta c : contas) {%>
            <tr>
                <td>Nímero: <%=c.getNumero()%></td>
                <td>Saldo: <%=c.getSaldo()%></td>
            </tr>
            <%}%>
        </table>
        <%}%>
        <br><a href="index.html">Voltar</a>
    </body>
</html>
