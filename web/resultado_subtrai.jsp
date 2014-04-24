<%-- 
    Document   : resultado_subtrai
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
        
        if(session.getAttribute("data_subtract_linesA") != null){
                linesA = (Integer)session.getAttribute("data_subtract_linesA");
        }
        if(session.getAttribute("data_subtract_columnsA") != null){
                columnsA = (Integer)session.getAttribute("data_subtract_columnsA");
        }

        double a[][] = new double[linesA][columnsA];
        double resultado[][] = new double[linesA][columnsA];
        if(session.getAttribute("result_subtract") != null){
                resultado = (double[][])session.getAttribute("result_subtract");
            }
        if(session.getAttribute("data_subtract_a") != null){
                a = (double[][])session.getAttribute("data_subtract_a");
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
        <a href="resposta_subtrai.jsp?operation=subtract">Subtração</a>
        <a href="resposta_soma.jsp?operation=subtract">Adição</a>
        <a href="resposta_multiplica.jsp?operation=subtract">Multiplicação</a>
        <a href="resposta_transposta.jsp?operation=subtract">Transposta</a>
        <a href="resposta_escalar.jsp?operation=subtract">Escalar</a>
        <%
        if(linesA==columnsA){
        out.print("<a href='resposta_inversa.jsp?operation=subtract'>Inversa</a>");
        out.print("<a href='resposta_determinante.jsp?operation=subtract'>Determinante</a>");
        }
        
        %>

    </body>
</html>
