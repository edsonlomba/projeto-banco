<%-- 
    Document   : sucessoLogin
    Created on : 14/09/2017, 21:55:10
    Author     : 41525388
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login bem sucedido</title>
    </head>
    <body>
        <%
            //allow access only if session exists
            String user = (String) session.getAttribute("usuario");
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("usuario")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            }
        %>
        <p style="font-family:verdana;font-weight:bold;font-size:16px">Olá <%=userName%>, login efetuado com sucesso. Esse é seu Session ID = <%=sessionID%></p>
        <br>
        <p style="font-family:verdana;font-size:12px">Usuário = <%=user%></p>
        <a href="index.html"><p style="font-family:verdana;font-size:12px">Gerenciar Contas</p></a>
        <br>
        <a href="checkout.jsp"><p style="font-family:verdana;font-size:12px">Efetuar Logoff</p></a>
    </body>
</html>