<%-- 
    Document   : resultado_determinante
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
        <%
        int i, j,linesA=0,columnsA=0;
        
        if(session.getAttribute("data_determinant_linesA") != null){
                linesA = (Integer)session.getAttribute("data_determinant_linesA");
        }
        if(session.getAttribute("data_determinant_columnsA") != null){
                columnsA = (Integer)session.getAttribute("data_determinant_columnsA");
        }

        double matrixA[][] = new double[linesA][columnsA];
        double resultado = 0;
        if(session.getAttribute("result_determinant") != null){
                resultado = (Double)session.getAttribute("result_determinant");
            }
        if(session.getAttribute("data_determinant_matrixA") != null){
                matrixA = (double[][])session.getAttribute("data_determinant_matrixA");
            }
        out.print("Resultado do Determinante: "+resultado);
        %>
        <a href="index.jsp">Voltar</a>
        <a href="resposta_determinant_escalar.jsp">Escalar</a>

    </body>
</html>
