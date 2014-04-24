<%-- 
    Document   : exit

    Author     : PC
--%>
<%
session.invalidate();
response.sendRedirect("index.jsp");
%>