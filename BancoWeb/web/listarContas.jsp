<%-- 
    Document   : listarContas
    Created on : 20/08/2017, 00:50:25
    Author     : Edson Lomba - 41525388
--%>
<%@page import="bancodao.Conta"%>
<%@page import="java.util.List"%>
<%@page import="bancodao.ContaDaoRelacional"%>
<%@page import="bancodao.ContaDaoInterface"%>
<%@page import="bancodao.ConexaoInterface"%>
<%@page import="bancodao.ConexaoJavaDb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Contas</title>
    </head>
    <body>
        <h1>Lista Contas:</h1>
        <%
            ConexaoInterface conexao = new ConexaoJavaDb("127.0.0.1",1527,"app","app","sistema_bancario");
            ContaDaoInterface dao = new ContaDaoRelacional(conexao);
            List<Conta> todasContas;
            todasContas = dao.obterTodos();
        %>
        <ul>
            <%
            for(Conta c: todasContas){
            %>
                    <li>Número: <%=c.getNumero()%> - Saldo: <%=c.getSaldo()%></li>
            <%
                }
            %>
        </ul>
    </body>
</html>
