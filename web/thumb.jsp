<%-- 
    Document   : thumb
    Author     : André
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thumb</title>
    </head>
    <body>
        <% if(request.getParameter("link") != null){
        String link = request.getParameter("link"); %>
        <img width="32" height="32" src="<%=link%>"/>
        <%
        }else out.print("Imagem inválida");

%>
    </body>
</html>
