<%-- 
    Document   : matriz_dinamica
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table class="centertable">
    <tr>
        <td></td>
        <%
        int i,j,slinesA=0,scolumnsA=0,linesA=0,columnsA=0;
        String op = "";
        
            if(request.getParameter("op") != null){
                op = request.getParameter("op");
            }

        if(session.getAttribute("resultado_"+op+"_linesA") != null){
                linesA = (Integer)session.getAttribute("resultado_"+op+"_linesA");
        }
        if(session.getAttribute("resultado_"+op+"_columnsA") != null){
                columnsA = (Integer)session.getAttribute("resultado_"+op+"_columnsA");
        }
        
        double resultado[][] = new double[linesA][columnsA];
        
        if(session.getAttribute("resultado_"+op) != null){
                resultado = (double[][])session.getAttribute("resultado_"+op);
        }
        
        for(i=0;i<columnsA;i++){
            %>
        <td><%=i%></td>
        <%}%>
        </tr>
        <%for(i=0;i<linesA;i++){
            %>
        <tr>
        <td><%=i%></td>
            <%
            for(j=0;j<columnsA;j++){
        %>
        <td> <input type="text" size="10" value="<%=resultado[i][j]%>" name="a<%=i%><%=j%>" id="a<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
</table>

