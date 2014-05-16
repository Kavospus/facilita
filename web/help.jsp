<%-- 
    Document   : help
    Created on : 02/12/2013, 08:55:42
    Author     : Andre
--%>

<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int option=0;
if(request.getParameter("option") != null){
option = Integer.parseInt(request.getParameter("option"));
}
if(((Locale) session.getAttribute("user_locale")).toString().equals("pt_BR")){
switch(option){

          case 1:
              %>       
Informe a ordem da matriz e insira os valores da mesma.
              <%
          break;
          case 2:
              %>
Informe o scalar e em seguida informe as dimensionões da matriz assim como seus valores.
              <%
          break;
          case 3:
              %>
Informe a ordem da matriz e insira os valores da mesma.
              <%
          break;
          case 4:
              %>
Informe a quantity de pontos experimentais na 1ª lacuna e selecione o tipo de função a ser ajustada. Digite as coordenadas de cada ponto, abicissas e ordenadas respectivamente.
              <%
          break;
          case 5:
              %>
Informe as dimensionões das matrixes obedecendo as restrições e seus valores.
              <%
          break;
          case 6:
              %>
Informe as dimensionões das matrixes e insira os valores das mesmas.
              <%
          break;
          case 7:
              %>
Informe as dimensionões das matrixes e insira os valores das mesmas.
              <%
          break;
          case 8:
              %>
Informe as dimensionões da matriz assim como seus valores.
              <%
          break;
}
}else if(((Locale) session.getAttribute("user_locale")).toString().equals("en_US")){
switch(option){

          case 1:
              %>       
Provide the order of the matrix and insert its values.
              <%
          break;
          case 2:
              %>
Provide the scalar and dimensions of the matrix and insert its values.
              <%
          break;
          case 3:
              %>
Provide the order of the matrix and insert its values.
              <%
          break;
          case 4:
              %>
Provide the quantity of experimental points and choose the adjust. Type each point coordinates.
              <%
          break;
          case 5:
              %>
Provide the restricted dimensions of the matrix and insert it's values.
              <%
          break;
          case 6:
              %>
Provide the dimensions of the matrices and insert their values.
              <%
          break;
          case 7:
              %>
Provide the dimensions of the matrices and insert their values.
              <%
          break;
          case 8:
              %>
Provide the dimensions of the matrices and insert their values.
              <%
          break;
}
}
%>