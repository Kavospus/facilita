<%-- 
    Document   : recebe_minimos_a
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
    <form action="calcular_minimos.do" method="POST" name="recebe_minimos">
            Quantidade <input type="text" name="quantidade" id="quantidade" onkeyup="refreshPage('least_squares','minimos_dinamicos.jsp?qnt='+getElementById('quantidade').value)" /><br>
        Ajuste <input type="radio" name="option" value="1">Linear 
              <input type="radio" name="option" value="2">Gaussiano
              <input type="radio" name="option" value="3">Parabólico
              <input type="radio" name="option" value="4">Exponencial
        <div id="least_squares"></div>
        <input class="button" type="submit" name="OK"/><img src="imagens/ajuda.png" width="20" height="20"onclick="refreshPage('ajuda', 'ajuda.jsp?option=4');"/>
        </form>
        
        <br>
        <div id="ajuda" ></div>
    </body>
</html>
