<%-- 
    Document   : recebe_minimos
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="centertable">
    <%
        int qnt = 0, i = 0, opcao=0, quantidade=0;
        double vx[] = {0,0};
        double vy[] = {0,0};
        if (request.getParameter("qnt") != null) {
            qnt = Integer.parseInt(request.getParameter("qnt"));
        }
        if(session.getAttribute("dados_minimos_vx") != null){
                vx = (double[])session.getAttribute("dados_minimos_vx");
        }
        if(session.getAttribute("dados_minimos_vy") != null){
                vy = (double[])session.getAttribute("dados_minimos_vy");
            }
        if(session.getAttribute("dados_minimos_opcao") != null){
                opcao = (Integer) session.getAttribute("dados_minimos_opcao");
            }
        if(session.getAttribute("dados_minimos_quantidade") != null){
                quantidade = (Integer) session.getAttribute("dados_minimos_quantidade");
            }
        for (i = 0; i < qnt; i++) {
    %>
    <tr>
        <td>X<%=i%> <input type="text" value="<%if(i<quantidade){out.print(vx[i]);}else{out.print(0.0);}%>" name="vx<%=i%>" id="vx<%=i%>" /></td>
        <td>Y<%=i%> <input type="text" value="<%if(i<quantidade){out.print(vy[i]);}else{out.print(0.0);}%>" name="vy<%=i%>" id="vy<%=i%>" /></td>
    </tr>
    <%}%>
</table>
