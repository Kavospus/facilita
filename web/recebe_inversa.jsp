<%-- 
    Document   : recebe_inversa
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
        <title>Recebe Inversa</title>
    </head>
    <body class="centertable">
        <%@include file="menu.jsp" %>
        <form action="invert_matrix.do" method="POST" name="invert_matrix">
        Linhas e Colunas <input type="text" name="linesA" id="linesA" onkeyup="refreshPage('matrixes', 'matriz_dinamica.jsp?linesA='+getElementById('linesA').value+'&columnsA='+getElementById('linesA').value)" />
        
        
        <div id="matrixes" ></div>
        <input class="button" type="submit" name="OK"/><img src="imagens/ajuda.png" width="20" height="20"onclick="refreshPage('ajuda', 'ajuda.jsp?option=3');"/>
        </form>
        
        <br>
        <div id="ajuda" ></div>
    </body>
</html>
