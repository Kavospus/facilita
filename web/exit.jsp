<%-- 
    Document   : exit

    Author     : PC
--%>
<%
session.invalidate();
response.sendRedirect("login.jsp");
%>