<%-- 
    Document   : recebe_escalar
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
        <form action="escalar_matriz.do" method="POST" name="escalar_matriz">
        Escalar <input type="text" name="n" id="n"/>
        Linhas <input type="text" name="dima" id="dima" onkeyup="refreshPage('matrizes', 'matriz_dinamica.jsp?dima='+getElementById('dima').value+'&dimb='+getElementById('dimb').value)" />
        Colunas <input type="text" name="dimb" id="dimb" onkeyup="refreshPage('matrizes', 'matriz_dinamica.jsp?dima='+getElementById('dima').value+'&dimb='+getElementById('dimb').value)" />
        
        <div id="matrizes" ></div>
        <input class="button" type="submit" name="OK"/><img src="imagens/ajuda.png" width="20" height="20"onclick="refreshPage('ajuda', 'ajuda.jsp?opcao=2');"/>
        </form>
        
        <br>
        <div id="ajuda" ></div>
    </body>
</html>
