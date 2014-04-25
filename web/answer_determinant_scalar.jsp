<%-- 
    Document   : recieve_scalar
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
    <%
    double number = 0;
    if(session.getAttribute("result_determinant") != null){
                number = (Double)session.getAttribute("result_determinant");
    }
    %>
    <body class="centertable">
        <%@include file="menu.jsp" %>
        <form action="scale_matrix.do" method="POST" name="scale_matrix">
            Escalar <input type="text" name="number" value="<%=number%>" id="n"/>
        Linhas <input type="text" name="linesA" id="linesA" onkeyup="refreshPage('matrixes', 'dynamic_matrix.jsp?linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value)" />
        Colunas <input type="text" name="columnsA" id="columnsA" onkeyup="refreshPage('matrixes', 'dynamic_matrix.jsp?linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value)" />
        
        <div id="matrixes" ></div>
        <input class="button" type="submit" name="OK"/>
        </form>
    </body>
</html>
