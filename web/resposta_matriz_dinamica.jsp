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
        int i,j,sdima=0,sdimb=0,dima=0,dimb=0;
        String op = "";
        
            if(request.getParameter("op") != null){
                op = request.getParameter("op");
            }

        if(session.getAttribute("resultado_"+op+"_dima") != null){
                dima = (Integer)session.getAttribute("resultado_"+op+"_dima");
        }
        if(session.getAttribute("resultado_"+op+"_dimb") != null){
                dimb = (Integer)session.getAttribute("resultado_"+op+"_dimb");
        }
        
        double resultado[][] = new double[dima][dimb];
        
        if(session.getAttribute("resultado_"+op) != null){
                resultado = (double[][])session.getAttribute("resultado_"+op);
        }
        
        for(i=0;i<dimb;i++){
            %>
        <td><%=i%></td>
        <%}%>
        </tr>
        <%for(i=0;i<dima;i++){
            %>
        <tr>
        <td><%=i%></td>
            <%
            for(j=0;j<dimb;j++){
        %>
        <td> <input type="text" size="10" value="<%=resultado[i][j]%>" name="a<%=i%><%=j%>" id="a<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
</table>

