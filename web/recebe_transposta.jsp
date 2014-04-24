<%-- 
    Document   : recebe_transposta
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
        <title>Recebe Transposta</title>
    </head>
    <body class="centertable">
        <%@include file="menu.jsp" %>
        <form action="transpor_matriz.do" method="POST" name="transpoe_matriz">
        Linhas <input type="text" name="linesA" id="linesA" onkeyup="refreshPage('matrizes', 'matriz_dinamica.jsp?linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value);" />
        Colunas <input type="text" name="columnsA" id="columnsA" onkeyup="refreshPage('matrizes', 'matriz_dinamica.jsp?linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value);" />
        
        
        <div id="matrizes" ></div>
        <input class="button" type="submit" name="OK"/><img src="imagens/ajuda.png" width="20" height="20"onclick="refreshPage('ajuda', 'ajuda.jsp?option=8');"/>
        </form>
        
        <br>
        <div id="ajuda" ></div>
    </body>
</html>
