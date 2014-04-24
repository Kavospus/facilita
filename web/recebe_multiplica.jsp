<%-- 
    Document   : recebe_matrizes
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
        <form action="multiplicar_matrizes.do" method="POST" name="multiplica_matrizes">
            Linhas de A <input type="text" name="linesA" id="linesA" onkeyup="refreshPage('matrizes', 'matrizes_dinamicas.jsp?linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value+'&linesB='+getElementById('columnsA').value+'&columnsB='+getElementById('linesB').value)" />
        Colunas de A e linhas de B <input type="text" name="columnsA" id="columnsA" onkeyup="refreshPage('matrizes', 'matrizes_dinamicas.jsp?linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value+'&linesB='+getElementById('columnsA').value+'&columnsB='+getElementById('linesB').value)" />
        Colunas de B <input type="text" name="linesB" id="linesB" onkeyup="refreshPage('matrizes', 'matrizes_dinamicas.jsp?linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value+'&linesB='+getElementById('columnsA').value+'&columnsB='+getElementById('linesB').value)" />
        <div id="matrizes" ></div>
        <input class="button" type="submit" name="OK"/><img src="imagens/ajuda.png" width="20" height="20"onclick="refreshPage('ajuda', 'ajuda.jsp?opcao=5');"/>
        </form>
        
        <br>
        <div id="ajuda" ></div>
    </body>
</html>
