<%-- 
    Document   : listarTitulares
    Created on : 25/08/2017, 18:31:03
    Author     : Edson Lomba - 41525388
--%>
<%@page import="bancodao.Titular"%>
<%@page import="java.util.List"%>
<%@page import="bancodao.TitularDaoRelacional"%>
<%@page import="bancodao.TitularDaoInterface"%>
<%@page import="bancodao.ConexaoInterface"%>
<%@page import="bancodao.ConexaoJavaDb"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Titulares</title>
    </head>
    <body>
        <h1>Lista Titulares:</h1>
        <%
            ConexaoInterface conexao = new ConexaoJavaDb("127.0.0.1",1527,"app","app","sistema_bancario");
            TitularDaoInterface dao = new TitularDaoRelacional(conexao);
            List<Titular> todosTitulares;
            todosTitulares = dao.obterTodos();
        %>
        <ul>
            <%
            for(Titular t: todosTitulares){
            %>
                    <li>Número Titular: <%=t.getNumero()%> - Nome <%=t.getNome()%> - RG <%=t.getRg()%> - CPF <%=t.getCpf()%></li>
            <%
                }
            %>
        </ul>
    </body>
</html>
