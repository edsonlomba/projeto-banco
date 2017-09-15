<%-- 
    Document   : Index
    Created on : 01/09/2017, 20:36:34
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
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Contas</h1>
        <%
            List<Conta> contas = (List<Conta>) request.getAttribute("lista_contas");
        %>
        <%if (contas.size() > 0) { %>
        <table>
            <% for (Conta c : contas) {%>
            <tr>
                <td><%=c.getNumero()%></td>
                <td><%=c.getSaldo()%></td>
            </tr>
            <%}%>
        </table>
        <%}%>
        <p><a href="index.html">Voltar</a></p>
    </body>
</html>