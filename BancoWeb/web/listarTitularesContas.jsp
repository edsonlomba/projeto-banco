<%-- 
    Document   : listarTitularesContas
    Created on : 25/08/2017, 18:31:40
    Author     : edson
--%>
<%@page import="bancodao.TitularConta"%>
<%@page import="java.util.List"%>
<%@page import="bancodao.TitularContaDaoRelacional"%>
<%@page import="bancodao.TitularContaDaoInterface"%>
<%@page import="bancodao.ConexaoInterface"%>
<%@page import="bancodao.ConexaoJavaDb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Titulares Contas</title>
    </head>
    <body>
        <h1>Lista Titulares Contas:</h1>
        <%
            ConexaoInterface conexao = new ConexaoJavaDb("127.0.0.1",1527,"app","app","sistema_bancario");
            TitularContaDaoInterface dao = new TitularContaDaoRelacional(conexao);
            List<TitularConta> titularContas;
            titularContas = dao.obterTodos();
        %>
        <ul>
            <%
            for(TitularConta tc: titularContas){
            %>
                    <li>Número Conta: <%=tc.getNroConta()%> - Número Titular <%=tc.getNroTitular()%></li>
            <%
                }
            %>
        </ul>
    </body>
</html>
