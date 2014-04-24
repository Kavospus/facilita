<%-- 
    Document   : dynamic_matrices
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table class="centertable">
            <tr>
                <td>
                    <table class="centertable">
              <tr>
                <td></td>
        <%
        int i,j,linesA=0,columnsA=0,linesB=0,columnsB=0;
            if(request.getParameter("linesA") != null){
                linesA = Integer.parseInt(request.getParameter("linesA"));
            }
            if(request.getParameter("columnsA") != null){
                columnsA = Integer.parseInt(request.getParameter("columnsA"));
            }
            if(request.getParameter("linesB") != null){
                linesB = Integer.parseInt(request.getParameter("linesB"));
            }
            if(request.getParameter("columnsB") != null){
                columnsB = Integer.parseInt(request.getParameter("columnsB"));
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
        <td><input size="10" type="text" name="matrixA<%=i%><%=j%>" id="matrixA<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        </td><td>
            <table class="centertable">
            <tr>
                <td></td>
        <%
        
        for(i=0;i<columnsB;i++){
            %>
        <td><%=i%></td>
        <%}%>
        </tr>
        <%for(i=0;i<linesB;i++){
            %>
        <tr>
        <td><%=i%></td>
            <%
            for(j=0;j<columnsB;j++){
        %>
        <td><input size="10" type="text" name="matrixB<%=i%><%=j%>" id="matrixB<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        </td>
        </tr>
</table>

