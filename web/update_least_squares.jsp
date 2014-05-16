<%-- 
    Document   : update_least_squares
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
    int option=0,quantity=0;
        if(session.getAttribute("data_least_squares_option") != null){
                option = (Integer) session.getAttribute("data_least_squares_option");
            }
        if(session.getAttribute("data_least_squares_quantity") != null){
                quantity = (Integer) session.getAttribute("data_least_squares_quantity");
            }

%>
<body class="centertable" onload="refreshPage('least_squares','dynamic_update_least_squares.jsp?auxiliarQuantity=<%=quantity%>');">
    <div class="header">
            <%@include file="menu.jsp" %>
        </div>    
    <form action="compute_least_squares.do" method="POST" name="compute_least_squares">
            <%=_("Quantity",bundle)%> <input type="text" value="<%=quantity%>" name="quantity" id="quantity" onkeyup="refreshPage('least_squares','dynamic_update_least_squares.jsp?auxiliarQuantity='+getElementById('quantity').value)" /><br>
        <%=_("Adjust",bundle)%> <input type="radio" <%if(option == 1){out.print("checked");}%> name="option" value="1"><%=_("Linear",bundle)%> 
              <input type="radio" <%if(option == 2){out.print("checked");}%> name="option" value="2"><%=_("Gaussian",bundle)%>
              <input type="radio" <%if(option == 3){out.print("checked");}%> name="option" value="3"><%=_("Parabolic",bundle)%>
              <input type="radio" <%if(option == 4){out.print("checked");}%> name="option" value="4"><%=_("Exponential",bundle)%>
        <div id="least_squares"></div>
        <input class="button"type="submit" value="<%=_("Calculate",bundle)%>"/>
        </form>
    </body>
</html>
