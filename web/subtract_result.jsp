<%-- 
    Document   : subtract_result
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
                <table class="centertable">
            <tr>
                <td></td>
        <%
        int i, j,linesA=0,columnsA=0;
        
        if(session.getAttribute("data_subtract_linesA") != null){
                linesA = (Integer)session.getAttribute("data_subtract_linesA");
        }
        if(session.getAttribute("data_subtract_columnsA") != null){
                columnsA = (Integer)session.getAttribute("data_subtract_columnsA");
        }

        double matrixA[][] = new double[linesA][columnsA];
        double result[][] = new double[linesA][columnsA];
        if(session.getAttribute("result_subtract") != null){
                result = (double[][])session.getAttribute("result_subtract");
            }
        if(session.getAttribute("data_subtract_matrixA") != null){
                matrixA = (double[][])session.getAttribute("data_subtract_matrixA");
            }

        
        
        for(i=0;i<columnsA;i++){
            %>
        <td><%=i%></td>
        <%}%>
        </tr>
        <%for(i=0;i<linesA;i++){
            %>
        <tr>
        <td><%=i%></td>
            <%
            for(j=0;j<columnsA;j++){
        %>
        <td> <input type="text" size="10" name="r<%=i%><%=j%>" value="<%=result[i][j]%>" id="r<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        <a href="index.jsp"><%=_("Back",bundle)%></a>
        <a href="answer_subtract.jsp?operation=subtract"><%=_("Subtract",bundle)%></a>
        <a href="answer_sum.jsp?operation=subtract"><%=_("Sum",bundle)%></a>
        <a href="answer_multiply.jsp?operation=subtract"><%=_("Multiply",bundle)%></a>
        <a href="answer_tranposed.jsp?operation=subtract"><%=_("Transpose",bundle)%></a>
        <a href="answer_scalar.jsp?operation=subtract"><%=_("Scalar",bundle)%></a>
        <%
        if(linesA==columnsA){
        out.print("<a href='answer_inverse.jsp?operation=subtract'>"+_("Invert",bundle)+"</a>");
        out.print("<a href='answer_determinant.jsp?operation=subtract'>"+_("Determinant",bundle)+"</a>");
        }
        
        %>

    </body>
</html>
