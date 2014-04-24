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

        if(request.getParameter("linesA") != null){
                linesA = Integer.parseInt(request.getParameter("linesA"));
            }
        if(request.getParameter("columnsA") != null){
                columnsA = Integer.parseInt(request.getParameter("columnsA"));
        }
        if(session.getAttribute("dados_"+op+"_linesA") != null){
                slinesA = (Integer)session.getAttribute("dados_"+op+"_linesA");
        }
        if(session.getAttribute("dados_"+op+"_columnsA") != null){
                scolumnsA = (Integer)session.getAttribute("dados_"+op+"_columnsA");
        }
        
        double a[][] = new double[slinesA][scolumnsA];
        
        if(session.getAttribute("dados_"+op+"_a") != null){
                a = (double[][])session.getAttribute("dados_"+op+"_a");
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
        <td><input type="text" size="10" value="<%if(i<slinesA && j<scolumnsA){out.print(a[i][j]);}else{out.print(0.0);}%>" name="a<%=i%><%=j%>" id="a<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
</table>

