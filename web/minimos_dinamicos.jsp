<%-- 
    Document   : recebe_minimos
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="centertable">
    <%
        int qnt = 0, i = 0;
        if (request.getParameter("qnt") != null) {
            qnt = Integer.parseInt(request.getParameter("qnt"));
        }
        for (i = 0; i < qnt; i++) {
    %>
    <tr>
        <td>X<%=i%> <input type="text" name="vx<%=i%>" id="vx<%=i%>" /></td>
        <td>Y<%=i%> <input type="text" name="vy<%=i%>" id="vy<%=i%>" /></td>
    </tr>
    <%}%>
</table>
