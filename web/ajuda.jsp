<%-- 
    Document   : ajuda
    Created on : 02/12/2013, 08:55:42
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int option=0;
if(request.getParameter("option") != null){
option = Integer.parseInt(request.getParameter("option"));
}
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
Informe as dimensionões das matrizes obedecendo as restrições e seus valores.
              <%
          break;
          case 6:
              %>
Informe as dimensionões das matrizes e insira os valores das mesmas.
              <%
          break;
          case 7:
              %>
Informe as dimensionões das matrizes e insira os valores das mesmas.
              <%
          break;
          case 8:
              %>
Informe as dimensionões da matriz assim como seus valores.
              <%
          break;
}
%>