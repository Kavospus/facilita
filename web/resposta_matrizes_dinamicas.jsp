<%-- 
    Document   : alterar_matrizes_dinamicas
    Author     : Andre
--%>
<%@page import="org.ejml.simple.SimpleMatrix"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<table class="centertable">
            <tr>
                <td>
        <table class="centertable">
            <tr>
                <td></td>
        <%
        int i,j,linesA=0,columnsA=0,linesB=0,columnsB=0,slinesA=0,scolumnsA=0,slinesB=0,scolumnsB=0;
        String operation ="";
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
            if(request.getParameter("operation") != null){
                operation = request.getParameter("operation");
            }
        
        if(session.getAttribute("result_"+operation+"_linesA") != null){
                linesA = (Integer)session.getAttribute("result_"+operation+"_linesA");
        }
        if(session.getAttribute("result_"+operation+"_columnsA") != null){
                columnsA = (Integer)session.getAttribute("result_"+operation+"_columnsA");
        }
        
        double resultado[][] = new double[linesA][columnsA];
        if(session.getAttribute("result_"+operation) != null){
                resultado = (double[][])session.getAttribute("result_"+operation);
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
        <td><input type="text" size="10" value="<%=resultado[i][j]%>" name="a<%=i%><%=j%>" id="a<%=i%><%=j%>" /></td>
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
        <td><input type="text" size="10" name="b<%=i%><%=j%>" id="b<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        </td>
        </tr>
</table>
