<%-- 
    Document   : resltado_inversa

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
        <title>Resultado Inversa</title>
    </head>
    <body class="centertable">
        <%@include file="menu.jsp" %>
        <table class="centertable">
            <tr>
                <td></td>
        <%
        int i, j,linesA=0,columnsA=0;
        
        if(session.getAttribute("data_inverse_linesA") != null){
                linesA = (Integer)session.getAttribute("data_inverse_linesA");
        }
        if(session.getAttribute("data_inverse_columnsA") != null){
                columnsA = (Integer)session.getAttribute("data_inverse_columnsA");
        }

        double matrixA[][] = new double[linesA][columnsA];
        double resultado[][] = new double[linesA][columnsA];
        if(session.getAttribute("result_inverse") != null){
                resultado = (double[][])session.getAttribute("result_inverse");
            }
        if(session.getAttribute("data_inverse_matrixA") != null){
                matrixA = (double[][])session.getAttribute("data_inverse_matrixA");
            }

        
        
        for(i=0;i<linesA;i++){
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
        <a href="resposta_subtrai.jsp?operation=inverse">Subtração</a>
        <a href="resposta_soma.jsp?operation=inverse">Adição</a>
        <a href="answer_multiply.jsp?operation=inverse">Multiplicação</a>
        <a href="resposta_transposta.jsp?operation=inverse">Transposta</a>
        <a href="answer_scalar.jsp?operation=inverse">Escalar</a>
        <%
        if(linesA==columnsA){
        out.print("<a href='answer_inverse.jsp?operation=inverse'>Inversa</a>");
        out.print("<a href='answer_determinant.jsp?operation=inverse'>Determinante</a>");
        }
        
        %>

    </body>
</html>