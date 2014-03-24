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
        
        if(session.getAttribute("dados_"+op+"_dima") != null){
                sdima = (Integer)session.getAttribute("dados_"+op+"_dima");
        }
        if(session.getAttribute("dados_"+op+"_dimb") != null){
                sdimb = (Integer)session.getAttribute("dados_"+op+"_dimb");
        }
        if(session.getAttribute("dados_"+op+"_dimc") != null){
                sdimc = (Integer)session.getAttribute("dados_"+op+"_dimc");
        }
        if(session.getAttribute("dados_"+op+"_dimd") != null){
                sdimd = (Integer)session.getAttribute("dados_"+op+"_dimd");
        }
        double a[][] = new double[sdima][sdimb];
        double b[][] = new double[sdimc][sdimd];
        if(session.getAttribute("dados_"+op+"_a") != null){
                a = (double[][])session.getAttribute("dados_"+op+"_a");
            }
        if(session.getAttribute("dados_"+op+"_b") != null){
                b = (double[][])session.getAttribute("dados_"+op+"_b");
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
            <td><input size="10" type="text" value="<%if(i<sdima && j<sdimb){out.print(a[i][j]);}else{out.print(0.0);}%>" name="a<%=i%><%=j%>" id="a<%=i%><%=j%>" /></td>
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
        <td><input size="10" type="text" value="<%if(i<sdimc && j<sdimd){out.print(b[i][j]);}else{out.print(0.0);}%>" name="b<%=i%><%=j%>" id="b<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        </td>
        </tr>
</table>
