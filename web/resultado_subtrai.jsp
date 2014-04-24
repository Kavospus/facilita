<%-- 
    Document   : resultado_subtrai
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
        
        if(session.getAttribute("dados_subtrai_linesA") != null){
                linesA = (Integer)session.getAttribute("dados_subtrai_linesA");
        }
        if(session.getAttribute("dados_subtrai_columnsA") != null){
                columnsA = (Integer)session.getAttribute("dados_subtrai_columnsA");
        }

        double a[][] = new double[linesA][columnsA];
        double resultado[][] = new double[linesA][columnsA];
        if(session.getAttribute("resultado_subtrai") != null){
                resultado = (double[][])session.getAttribute("resultado_subtrai");
            }
        if(session.getAttribute("dados_subtrai_a") != null){
                a = (double[][])session.getAttribute("dados_subtrai_a");
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
        <td> <input type="text" size="10" name="r<%=i%><%=j%>" value="<%=resultado[i][j]%>" id="r<%=i%><%=j%>" /></td>
        <%}%>
        </tr>
        <%}%>
        </table>
        <a href="index.jsp">Voltar</a>
        <a href="resposta_subtrai.jsp?op=subtrai">Subtração</a>
        <a href="resposta_soma.jsp?op=subtrai">Adição</a>
        <a href="resposta_multiplica.jsp?op=subtrai">Multiplicação</a>
        <a href="resposta_transposta.jsp?op=subtrai">Transposta</a>
        <a href="resposta_escalar.jsp?op=subtrai">Escalar</a>
        <%
        if(linesA==columnsA){
        out.print("<a href='resposta_inversa.jsp?op=subtrai'>Inversa</a>");
        out.print("<a href='resposta_determinante.jsp?op=subtrai'>Determinante</a>");
        }
        
        %>

    </body>
</html>
