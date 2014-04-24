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
        int i, j,linesA=0,columnsA=0;
        
        if(session.getAttribute("data_soma_linesA") != null){
                linesA = (Integer)session.getAttribute("data_soma_linesA");
        }
        if(session.getAttribute("data_soma_columnsA") != null){
                columnsA = (Integer)session.getAttribute("data_soma_columnsA");
        }

        double a[][] = new double[linesA][columnsA];
        double resultado[][] = new double[linesA][columnsA];
        if(session.getAttribute("result_soma") != null){
                resultado = (double[][])session.getAttribute("result_soma");
            }
        if(session.getAttribute("data_soma_a") != null){
                a = (double[][])session.getAttribute("data_soma_a");
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
        <td> <input type="text" size="10" name="r<%=i%><%=j%>" value="<%=resultado[i][j]%>" id="r<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        <a href="index.jsp">Voltar</a>
        <a href="resposta_subtrai.jsp?operation=soma">Subtração</a>
        <a href="resposta_soma.jsp?operation=soma">Adição</a>
        <a href="resposta_multiplica.jsp?operation=soma">Multiplicação</a>
        <a href="resposta_transposta.jsp?operation=soma">Transposta</a>
        <a href="resposta_escalar.jsp?operation=soma">Escalar</a>
        <%
        if(linesA==columnsA){
        out.print("<a href='resposta_inversa.jsp?operation=soma'>Inversa</a>");
        out.print("<a href='resposta_determinante.jsp?operation=soma'>Determinante</a>");
        }
        
        %>

    </body>
</html>
