<%-- 
    Document   : recieve_inverse
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
        <%=_("Lines",bundle)%> <%=_("and",bundle)%> <%=_("Columns",bundle)%> <input type="text" name="linesA" id="linesA" onkeyup="refreshPage('matrixes', 'dynamic_matrix.jsp?linesA='+getElementById('linesA').value+'&columnsA='+getElementById('linesA').value)" />
        
        
        <div id="matrixes" ></div>
        <input class="button" type="submit" value="<%=_("Calculate",bundle)%>"/><img src="imagens/ajuda.png" width="20" height="20"onclick="refreshPage('help', 'help.jsp?option=3');"/>
        </form>
        
        <br>
        <div id="help" ></div>
    </body>
</html>
