<%-- 
    Document   : ajuda
    Created on : 02/12/2013, 08:55:42
    Author     : Andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int opcao=0;
if(request.getParameter("opcao") != null){
opcao = Integer.parseInt(request.getParameter("opcao"));
}
switch(opcao){

          case 1:
              %>       
Informe a ordem da matriz e insira os valores da mesma.
              <%
          break;
          case 2:
              %>
Informe o escalar e em seguida informe as dimensões da matriz assim como seus valores.
              <%
          break;
          case 3:
              %>
Informe a ordem da matriz e insira os valores da mesma.
              <%
          break;
          case 4:
              %>
Informe a quantidade de pontos experimentais na 1ª lacuna e selecione o tipo de função a ser ajustada. Digite as coordenadas de cada ponto, abicissas e ordenadas respectivamente.
              <%
          break;
          case 5:
              %>
Informe as dimensões das matrizes obedecendo as restrições e seus valores.
              <%
          break;
          case 6:
              %>
Informe as dimensões das matrizes e insira os valores das mesmas.
              <%
          break;
          case 7:
              %>
Informe as dimensões das matrizes e insira os valores das mesmas.
              <%
          break;
          case 8:
              %>
Informe as dimensões da matriz assim como seus valores.
              <%
          break;
}
%>