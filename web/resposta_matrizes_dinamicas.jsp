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
        int i,j,dima=0,dimb=0,dimc=0,dimd=0,sdima=0,sdimb=0,sdimc=0,sdimd=0;
        String op ="";
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
        <td><input type="text" size="10" name="b<%=i%><%=j%>" id="b<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        </td>
        </tr>
</table>
