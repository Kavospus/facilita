<%-- 
    Document   : multiply_result
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
        int i, j,linesA=0,columnsA=0,linesB=0,columnsB=0;
        
        if(session.getAttribute("data_multiply_linesA") != null){
                linesA = (Integer)session.getAttribute("data_multiply_linesA");
        }
        if(session.getAttribute("data_multiply_columnsA") != null){
                columnsA = (Integer)session.getAttribute("data_multiply_columnsA");
        }
        if(session.getAttribute("data_multiply_linesB") != null){
                linesB = (Integer)session.getAttribute("data_multiply_linesB");
        }
        if(session.getAttribute("data_multiply_columnsB") != null){
                columnsB = (Integer)session.getAttribute("data_multiply_columnsB");
        }
        double matrixA[][] = new double[linesA][columnsA];
        double matrixB[][] = new double[linesB][columnsB];
        double result[][] = new double[linesA][linesB];
        if(session.getAttribute("result_multiply") != null){
                result = (double[][])session.getAttribute("result_multiply");
            }
        if(session.getAttribute("data_multiply_matrixA") != null){
                matrixA = (double[][])session.getAttribute("data_multiply_matrixA");
            }
        if(session.getAttribute("data_multiply_matrixB") != null){
                matrixB = (double[][])session.getAttribute("data_multiply_matrixB");
            }
        
        
        for(i=0;i<columnsB;i++){
            %>
        <td><%=i%></td>
        <%}%>
        </tr>
        <%for(i=0;i<linesA;i++){
            %>
        <tr>
        <td><%=i%></td>
            <%
            for(j=0;j<columnsB;j++){
        %>
        <td> <input type="text" size="10" name="r<%=i%><%=j%>" value="<%=result[i][j]%>" id="r<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        <a href="index.jsp"><%=_("Back",bundle)%></a>
        <a href="answer_subtract.jsp?operation=multiply"><%=_("Subtract",bundle)%></a>
        <a href="answer_sum.jsp?operation=multiply"><%=_("Sum",bundle)%></a>
        <a href="answer_multiply.jsp?operation=multiply"><%=_("Multiply",bundle)%></a>
        <a href="answer_tranposed.jsp?operation=multiply"><%=_("Transpose",bundle)%></a>
        <a href="answer_scalar.jsp?operation=multiply"><%=_("Scalar",bundle)%></a>
        <%
        if(linesA==columnsB){
        out.print("<a href='answer_inverse.jsp?operation=multiply'>"+_("Invert",bundle)+"</a>");
        out.print("<a href='answer_determinant.jsp?operation=multiply'>"+_("Determinant",bundle)+"</a>");
        }
        
        %>

    </body>
</html>
