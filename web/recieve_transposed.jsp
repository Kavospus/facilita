<%-- 
    Document   : recieve_transposed
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
        <form action="transpose_matrix.do" method="POST" name="transpose_matrix">
        <%=_("Lines",bundle)%> <input type="text" name="linesA" id="linesA" onkeyup="refreshPage('matrixes', 'dynamic_matrix.jsp?linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value);" />
        <%=_("Columns",bundle)%> <input type="text" name="columnsA" id="columnsA" onkeyup="refreshPage('matrixes', 'dynamic_matrix.jsp?linesA='+getElementById('linesA').value+'&columnsA='+getElementById('columnsA').value);" />
        
        
        <div id="matrixes" ></div>
        <input class="button" type="submit" value="<%=_("Calculate",bundle)%>"/><img src="imagens/ajuda.png" width="20" height="20"onclick="refreshPage('help', 'help.jsp?option=8');"/>
        </form>
        
        <br>
        <div id="help" ></div>
    </body>
</html>
