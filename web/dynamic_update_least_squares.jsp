<%-- 
    Document   : recieve_least_squares
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="centertable">
    <%
        int auxiliarQuantity = 0, i = 0, option=0, quantity=0;
        double vectorX[] = {0,0};
        double vectorY[] = {0,0};
        if (request.getParameter("auxiliarQuantity") != null) {
            auxiliarQuantity = Integer.parseInt(request.getParameter("auxiliarQuantity"));
        }
        if(session.getAttribute("data_least_squares_vectorX") != null){
                vectorX = (double[])session.getAttribute("data_least_squares_vectorX");
        }
        if(session.getAttribute("data_least_squares_vectorY") != null){
                vectorY = (double[])session.getAttribute("data_least_squares_vectorY");
            }
        if(session.getAttribute("data_least_squares_option") != null){
                option = (Integer) session.getAttribute("data_least_squares_option");
            }
        if(session.getAttribute("data_least_squares_quantity") != null){
                quantity = (Integer) session.getAttribute("data_least_squares_quantity");
            }
        for (i = 0; i < auxiliarQuantity; i++) {
    %>
    <tr>
        <td>X<%=i%> <input type="text" value="<%if(i<quantity){out.print(vectorX[i]);}else{out.print(0.0);}%>" name="vectorX<%=i%>" id="vectorX<%=i%>" /></td>
        <td>Y<%=i%> <input type="text" value="<%if(i<quantity){out.print(vectorY[i]);}else{out.print(0.0);}%>" name="vectorY<%=i%>" id="vectorY<%=i%>" /></td>
    </tr>
    <%}%>
</table>
