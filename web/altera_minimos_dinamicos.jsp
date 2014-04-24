<%-- 
    Document   : recebe_minimos
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="centertable">
    <%
        int qnt = 0, i = 0, option=0, quantidade=0;
        double vx[] = {0,0};
        double vy[] = {0,0};
        if (request.getParameter("qnt") != null) {
            qnt = Integer.parseInt(request.getParameter("qnt"));
        }
        if(session.getAttribute("data_least_squares_vx") != null){
                vx = (double[])session.getAttribute("data_least_squares_vx");
        }
        if(session.getAttribute("data_least_squares_vy") != null){
                vy = (double[])session.getAttribute("data_least_squares_vy");
            }
        if(session.getAttribute("data_least_squares_option") != null){
                option = (Integer) session.getAttribute("data_least_squares_option");
            }
        if(session.getAttribute("data_least_squares_quantidade") != null){
                quantidade = (Integer) session.getAttribute("data_least_squares_quantidade");
            }
        for (i = 0; i < qnt; i++) {
    %>
    <tr>
        <td>X<%=i%> <input type="text" value="<%if(i<quantidade){out.print(vx[i]);}else{out.print(0.0);}%>" name="vx<%=i%>" id="vx<%=i%>" /></td>
        <td>Y<%=i%> <input type="text" value="<%if(i<quantidade){out.print(vy[i]);}else{out.print(0.0);}%>" name="vy<%=i%>" id="vy<%=i%>" /></td>
    </tr>
    <%}%>
</table>
