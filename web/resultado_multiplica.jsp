<%-- 
    Document   : resultado_multiplica
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/custom-theme/jquery-ui-1.8.21.custom.css" rel="stylesheet" type="text/css">
        <link href="css/main.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/ajax.js"></script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/jquery-ui-1.8.21.custom.min.js"></script>
        <script type="text/javascript" src="js/querySets.js"></script>
        <script type="text/javascript" src="js/canvasManager.js"></script>
        <title>JSP Page</title>
    </head>
    <body class="centertable">
        <%@include file="menu.jsp" %>
        <table class="centertable">
            <tr>
                <td></td>
        <%
        int i, j,dima=0,dimb=0,dimc=0,dimd=0;
        
        if(session.getAttribute("dados_multiplica_dima") != null){
                dima = (Integer)session.getAttribute("dados_multiplica_dima");
        }
        if(session.getAttribute("dados_multiplica_dimb") != null){
                dimb = (Integer)session.getAttribute("dados_multiplica_dimb");
        }
        if(session.getAttribute("dados_multiplica_dimc") != null){
                dimc = (Integer)session.getAttribute("dados_multiplica_dimc");
        }
        if(session.getAttribute("dados_multiplica_dimd") != null){
                dimd = (Integer)session.getAttribute("dados_multiplica_dimd");
        }
        double a[][] = new double[dima][dimb];
        double b[][] = new double[dimc][dimd];
        double resultado[][] = new double[dima][dimc];
        if(session.getAttribute("resultado_multiplica") != null){
                resultado = (double[][])session.getAttribute("resultado_multiplica");
            }
        if(session.getAttribute("dados_mmultiplica_a") != null){
                a = (double[][])session.getAttribute("dados_mmultiplica_a");
            }
        if(session.getAttribute("dados_mmultiplica_b") != null){
                b = (double[][])session.getAttribute("dados_mmultiplica_b");
            }
        
        
        for(i=0;i<dimd;i++){
            %>
        <td><%=i%></td>
        <%}%>
        </tr>
        <%for(i=0;i<dima;i++){
            %>
        <tr>
        <td><%=i%></td>
            <%
            for(j=0;j<dimd;j++){
        %>
        <td> <input type="text" size="10" name="r<%=i%><%=j%>" value="<%=resultado[i][j]%>" id="r<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        <a href="index.jsp">Voltar</a>
        <a href="resposta_subtrai.jsp?op=multiplica">Subtração</a>
        <a href="resposta_soma.jsp?op=multiplica">Adição</a>
        <a href="resposta_multiplica.jsp?op=multiplica">Multiplicação</a>
        <a href="resposta_transposta.jsp?op=multiplica">Transposta</a>
        <a href="resposta_escalar.jsp?op=multiplica">Escalar</a>
        <%
        if(dima==dimd){
        out.print("<a href='resposta_inversa.jsp?op=multiplica'>Inversa</a>");
        out.print("<a href='resposta_determinante.jsp?op=multiplica'>Determinante</a>");
        }
        
        %>

    </body>
</html>
