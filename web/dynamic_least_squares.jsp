<%-- 
    Document   : recieve_least_squares
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="centertable">
    <%
        int auxiliarQuantity = 0, i = 0;
        if (request.getParameter("auxiliarQuantity") != null) {
            auxiliarQuantity = Integer.parseInt(request.getParameter("auxiliarQuantity"));
        }
        for (i = 0; i < auxiliarQuantity; i++) {
    %>
    <tr>
        <td>X<%=i%> <input type="text" name="vectorX<%=i%>" id="vectorX<%=i%>" /></td>
        <td>Y<%=i%> <input type="text" name="vectorY<%=i%>" id="vectorY<%=i%>" /></td>
    </tr>
    <%}%>
</table>
