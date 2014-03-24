<%-- 
    Document   : matrizes_dinamicas
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
        int i,j,dima=0,dimb=0,dimc=0,dimd=0;
            if(request.getParameter("dima") != null){
                dima = Integer.parseInt(request.getParameter("dima"));
            }
            if(request.getParameter("dimb") != null){
                dimb = Integer.parseInt(request.getParameter("dimb"));
            }
            if(request.getParameter("dimc") != null){
                dimc = Integer.parseInt(request.getParameter("dimc"));
            }
            if(request.getParameter("dimd") != null){
                dimd = Integer.parseInt(request.getParameter("dimd"));
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
        <td><input size="10" type="text" name="a<%=i%><%=j%>" id="a<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        </td><td>
            <table class="centertable">
            <tr>
                <td></td>
        <%
        
        for(i=0;i<dimd;i++){
            %>
        <td><%=i%></td>
        <%}%>
        </tr>
        <%for(i=0;i<dimc;i++){
            %>
        <tr>
        <td><%=i%></td>
            <%
            for(j=0;j<dimd;j++){
        %>
        <td><input size="10" type="text" name="b<%=i%><%=j%>" id="b<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        </td>
        </tr>
</table>

