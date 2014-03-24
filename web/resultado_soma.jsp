<%-- 
    Document   : resultado_soma
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
        int i, j,dima=0,dimb=0;
        
        if(session.getAttribute("dados_soma_dima") != null){
                dima = (Integer)session.getAttribute("dados_soma_dima");
        }
        if(session.getAttribute("dados_soma_dimb") != null){
                dimb = (Integer)session.getAttribute("dados_soma_dimb");
        }

        double a[][] = new double[dima][dimb];
        double resultado[][] = new double[dima][dimb];
        if(session.getAttribute("resultado_soma") != null){
                resultado = (double[][])session.getAttribute("resultado_soma");
            }
        if(session.getAttribute("dados_soma_a") != null){
                a = (double[][])session.getAttribute("dados_soma_a");
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
        <td> <input type="text" size="10" name="r<%=i%><%=j%>" value="<%=resultado[i][j]%>" id="r<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        <a href="index.jsp">Voltar</a>
        <a href="resposta_subtrai.jsp?op=soma">Subtração</a>
        <a href="resposta_soma.jsp?op=soma">Adição</a>
        <a href="resposta_multiplica.jsp?op=soma">Multiplicação</a>
        <a href="resposta_transposta.jsp?op=soma">Transposta</a>
        <a href="resposta_escalar.jsp?op=soma">Escalar</a>
        <%
        if(dima==dimb){
        out.print("<a href='resposta_inversa.jsp?op=soma'>Inversa</a>");
        out.print("<a href='resposta_determinante.jsp?op=soma'>Determinante</a>");
        }
        
        %>

    </body>
</html>
