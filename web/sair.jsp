<%-- 
    Document   : sair

    Author     : PC
--%>
<%
session.invalidate();
response.sendRedirect("index.jsp");
%>