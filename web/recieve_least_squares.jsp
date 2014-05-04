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
    <form action="compute_least_squares.do" method="POST" name="compute_least_squares">
            <%=_("Quantity",bundle)%> <input type="text" name="quantity" id="quantity" onkeyup="refreshPage('least_squares','dynamic_least_squares.jsp?auxiliarQuantity='+getElementById('quantity').value)" /><br>
        <%=_("Adjust",bundle)%> <input type="radio" name="option" value="1"> <%=_("Linear",bundle)%>
              <input type="radio" name="option" value="2"><%=_("Gaussian",bundle)%>
              <input type="radio" name="option" value="3"><%=_("Parabolic",bundle)%>
              <input type="radio" name="option" value="4"><%=_("Exponential",bundle)%>
        <div id="least_squares"></div>
        <input class="button" type="submit" value="<%=_("Calculate",bundle)%>"/><img src="imagens/ajuda.png" width="20" height="20"onclick="refreshPage('help', 'help.jsp?option=4');"/>
        </form>
        
        <br>
        <div id="help" ></div>
    </body>
</html>
