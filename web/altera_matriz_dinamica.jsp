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

        if(request.getParameter("dima") != null){
                dima = Integer.parseInt(request.getParameter("dima"));
            }
        if(request.getParameter("dimb") != null){
                dimb = Integer.parseInt(request.getParameter("dimb"));
        }
        if(session.getAttribute("dados_"+op+"_dima") != null){
                sdima = (Integer)session.getAttribute("dados_"+op+"_dima");
        }
        if(session.getAttribute("dados_"+op+"_dimb") != null){
                sdimb = (Integer)session.getAttribute("dados_"+op+"_dimb");
        }
        
        double a[][] = new double[sdima][sdimb];
        
        if(session.getAttribute("dados_"+op+"_a") != null){
                a = (double[][])session.getAttribute("dados_"+op+"_a");
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
        <td><input type="text" size="10" value="<%if(i<sdima && j<sdimb){out.print(a[i][j]);}else{out.print(0.0);}%>" name="a<%=i%><%=j%>" id="a<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
</table>

