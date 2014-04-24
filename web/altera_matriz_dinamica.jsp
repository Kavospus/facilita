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
        String operation = "";
        
            if(request.getParameter("operation") != null){
                operation = request.getParameter("operation");
            }

        if(request.getParameter("linesA") != null){
                linesA = Integer.parseInt(request.getParameter("linesA"));
            }
        if(request.getParameter("columnsA") != null){
                columnsA = Integer.parseInt(request.getParameter("columnsA"));
        }
        if(session.getAttribute("data_"+operation+"_linesA") != null){
                slinesA = (Integer)session.getAttribute("data_"+operation+"_linesA");
        }
        if(session.getAttribute("data_"+operation+"_columnsA") != null){
                scolumnsA = (Integer)session.getAttribute("data_"+operation+"_columnsA");
        }
        
        double matrixA[][] = new double[slinesA][scolumnsA];
        
        if(session.getAttribute("data_"+operation+"_matrixA") != null){
                matrixA = (double[][])session.getAttribute("data_"+operation+"_matrixA");
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
        <td><input type="text" size="10" value="<%if(i<slinesA && j<scolumnsA){out.print(matrixA[i][j]);}else{out.print(0.0);}%>" name="matrixA<%=i%><%=j%>" id="matrixA<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
</table>

