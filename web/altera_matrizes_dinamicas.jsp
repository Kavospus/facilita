<%-- 
    Document   : alterar_matrizes_dinamicas
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
        int i,j,linesA=0,columnsA=0,linesB=0,columnsB=0,slinesA=0,scolumnsA=0,slinesB=0,scolumnsB=0;
        String op ="";
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
            if(request.getParameter("op") != null){
                op = request.getParameter("op");
            }
        
        if(session.getAttribute("dados_"+op+"_linesA") != null){
                slinesA = (Integer)session.getAttribute("dados_"+op+"_linesA");
        }
        if(session.getAttribute("dados_"+op+"_columnsA") != null){
                scolumnsA = (Integer)session.getAttribute("dados_"+op+"_columnsA");
        }
        if(session.getAttribute("dados_"+op+"_linesB") != null){
                slinesB = (Integer)session.getAttribute("dados_"+op+"_linesB");
        }
        if(session.getAttribute("dados_"+op+"_columnsB") != null){
                scolumnsB = (Integer)session.getAttribute("dados_"+op+"_columnsB");
        }
        double a[][] = new double[slinesA][scolumnsA];
        double b[][] = new double[slinesB][scolumnsB];
        if(session.getAttribute("dados_"+op+"_a") != null){
                a = (double[][])session.getAttribute("dados_"+op+"_a");
            }
        if(session.getAttribute("dados_"+op+"_b") != null){
                b = (double[][])session.getAttribute("dados_"+op+"_b");
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
            <td><input size="10" type="text" value="<%if(i<slinesA && j<scolumnsA){out.print(a[i][j]);}else{out.print(0.0);}%>" name="a<%=i%><%=j%>" id="a<%=i%><%=j%>" /></td>
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
        <td><input size="10" type="text" value="<%if(i<slinesB && j<scolumnsB){out.print(b[i][j]);}else{out.print(0.0);}%>" name="b<%=i%><%=j%>" id="b<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        </td>
        </tr>
</table>
