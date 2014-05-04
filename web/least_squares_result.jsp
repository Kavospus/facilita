<%-- 
    Document   : least_squares_result
    Author     : Andre
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
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
        <% 
        double result[] = {0,0};
        double aux,vectorX[] = {0,0};
        double vectorY[] = {0,0};
        String erro;
        int dimension=2,ticks,i,j,option =0, auxiliarQuantity =0;
        if(session.getAttribute("result_least_squares") != null){
                result = (double[])session.getAttribute("result_least_squares");
            }
        if(session.getAttribute("data_least_squares_vectorX") != null){
                vectorX = (double[])session.getAttribute("data_least_squares_vectorX");
            }
        if(session.getAttribute("data_least_squares_vectorY") != null){
                vectorY = (double[])session.getAttribute("data_least_squares_vectorY");
            }
        if(session.getAttribute("erro_minimos") != null){
                erro = (String)session.getAttribute("erro_minimos");
                out.print(erro);
            }
        if(session.getAttribute("data_least_squares_option") != null){
                option = (Integer) session.getAttribute("data_least_squares_option");
            }
        if(request.getParameter("dimension") != null){
                dimension = Integer.parseInt(request.getParameter("dimension"));
            }
        auxiliarQuantity = vectorX.length;
        ArrayList<Double> auxiliarVectorX = new ArrayList();
        ArrayList<Double> auxiliarVectorY = new ArrayList();
        for(i=0; i<auxiliarQuantity; i++){  
            auxiliarVectorX.add(Math.abs(vectorX[i]));
            auxiliarVectorY.add(Math.abs(vectorY[i]));
        }
        
        Collections.sort(auxiliarVectorX);
        Collections.sort(auxiliarVectorY);
        
        if(auxiliarVectorX.get(auxiliarQuantity-1)<20||auxiliarVectorY.get(auxiliarQuantity-1)<20){
        ticks = 1;
        }else if(auxiliarVectorX.get(auxiliarQuantity-1)>=20 && auxiliarVectorX.get(auxiliarQuantity-1)<120 || auxiliarVectorY.get(auxiliarQuantity-1)>=20 && auxiliarVectorY.get(auxiliarQuantity-1)<120){
        ticks = 10;
        }else ticks = 100;
        
        for(i=0;i<dimension;i++){
        %>
                <td><%if(i == 0){
                    out.print("A = "+result[i]);
                }else if(i==1){
                    out.print("B = "+result[i]);
                }else if(i==2){
                    out.print("C = "+result[i]);
                }%></td>        
        <%}%>
            </tr>
        </table>
            <%=_("Adjust Function",bundle)%> f(x)=<%
        switch(option){
            case 1:
                out.print("("+result[0]+")*x + ("+result[1]+")");
            break;
            case 2:
                out.print("("+result[0]+")*exp(("+result[1]+")*(x+("+result[2]+"))^2)");
            break;
            case 3:
                out.print("("+result[0]+")+("+result[1]+")*x+("+result[2]+")*x^2");
            break;
            case 4:
                out.print("("+result[0]+")*exp(("+result[1]+")*x)");
            break;
        }
        
        %>
        <br>
        <a href="index.jsp"><%=_("Back",bundle)%></a>
        <a href="update_least_squares.jsp"><%=_("Edit Operation",bundle)%></a>
        <br>
        
        <canvas id="myCanvas" width="600" height="600" >
        Your browser does not support the HTML5 canvas tag.</canvas>
        

    <script>
      function Graph(config) {
        // userLogged defined properties
        this.canvas = document.getElementById(config.canvasId);
        this.minX = config.minX;
        this.minY = config.minY;
        this.maxX = config.maxX;
        this.maxY = config.maxY;
        this.unitsPerTick = config.unitsPerTick;


        // constants
        this.axisColor = '#aaa';
        this.font = '8pt Calibri';
        this.tickSize = 20;

        // relationships
        this.context = this.canvas.getContext('2d');
        this.rangeX = this.maxX - this.minX;
        this.rangeY = this.maxY - this.minY;
        this.unitX = this.canvas.width / this.rangeX;
        this.unitY = this.canvas.height / this.rangeY;
        this.centerY = Math.round(Math.abs(this.minY / this.rangeY) * this.canvas.height);
        this.centerX = Math.round(Math.abs(this.minX / this.rangeX) * this.canvas.width);
        this.iteration = (this.maxX - this.minX) / 1000;
        this.scaleX = this.canvas.width / this.rangeX;
        this.scaleY = this.canvas.height / this.rangeY;
        
        // draw x and y axis
        this.drawXAxis();
        this.drawYAxis();
      }

      Graph.prototype.drawXAxis = function() {
        var context = this.context;
        context.save();
        context.beginPath();
        context.moveTo(0, this.centerY);
        context.lineTo(this.canvas.width, this.centerY);
        context.strokeStyle = this.axisColor;
        context.lineWidth = 2;
        context.stroke();

        // draw tick marks
        var xPosIncrement = this.unitsPerTick * this.unitX;
        var xPos, unit;
        context.font = this.font;
        context.textAlign = 'center';
        context.textBaseline = 'top';

        // draw left tick marks
        xPos = this.centerX - xPosIncrement;
        unit = -1 * this.unitsPerTick;
        while(xPos > 0) {
          context.moveTo(xPos, this.centerY - this.tickSize / 2);
          context.lineTo(xPos, this.centerY + this.tickSize / 2);
          context.stroke();
          context.fillText(unit, xPos, this.centerY + this.tickSize / 2 + 3);
          unit -= this.unitsPerTick;
          xPos = Math.round(xPos - xPosIncrement);
        }

        // draw right tick marks
        xPos = this.centerX + xPosIncrement;
        unit = this.unitsPerTick;
        while(xPos < this.canvas.width) {
          context.moveTo(xPos, this.centerY - this.tickSize / 2);
          context.lineTo(xPos, this.centerY + this.tickSize / 2);
          context.stroke();
          context.fillText(unit, xPos, this.centerY + this.tickSize / 2 + 3);
          unit += this.unitsPerTick;
          xPos = Math.round(xPos + xPosIncrement);
        }
        context.restore();
      };

      Graph.prototype.drawYAxis = function() {
        var context = this.context;
        context.save();
        context.beginPath();
        context.moveTo(this.centerX, 0);
        context.lineTo(this.centerX, this.canvas.height);
        context.strokeStyle = this.axisColor;
        context.lineWidth = 2;
        context.stroke();

        // draw tick marks
        var yPosIncrement = this.unitsPerTick * this.unitY;
        var yPos, unit;
        context.font = this.font;
        context.textAlign = 'right';
        context.textBaseline = 'middle';

        // draw top tick marks
        yPos = this.centerY - yPosIncrement;
        unit = this.unitsPerTick;
        while(yPos > 0) {
          context.moveTo(this.centerX - this.tickSize / 2, yPos);
          context.lineTo(this.centerX + this.tickSize / 2, yPos);
          context.stroke();
          context.fillText(unit, this.centerX - this.tickSize / 2 - 3, yPos);
          unit += this.unitsPerTick;
          yPos = Math.round(yPos - yPosIncrement);
        }

        // draw bottom tick marks
        yPos = this.centerY + yPosIncrement;
        unit = -1 * this.unitsPerTick;
        while(yPos < this.canvas.height) {
          context.moveTo(this.centerX - this.tickSize / 2, yPos);
          context.lineTo(this.centerX + this.tickSize / 2, yPos);
          context.stroke();
          context.fillText(unit, this.centerX - this.tickSize / 2 - 3, yPos);
          unit -= this.unitsPerTick;
          yPos = Math.round(yPos + yPosIncrement);
        }
        context.restore();
      };
      Graph.prototype.drawPoint = function(px,py) {
        var context = this.context;
        context.save();
        context.beginPath();
        context.moveTo((px+(this.centerX/this.scaleX))*this.scaleX, (-py+(this.centerY/this.scaleY))*this.scaleY+10);
        context.lineTo((px+(this.centerX/this.scaleX))*this.scaleX, (-py+(this.centerY/this.scaleY))*this.scaleY-10);
        context.moveTo((px+(this.centerX/this.scaleX))*this.scaleX+10, (-py+(this.centerY/this.scaleY))*this.scaleY);
        context.lineTo((px+(this.centerX/this.scaleX))*this.scaleX-10, (-py+(this.centerY/this.scaleY))*this.scaleY);
        context.fillText("("+px+","+py+")",(px+(this.centerX/this.scaleX))*this.scaleX-24, (-py+(this.centerY/this.scaleY))*this.scaleY-12);
        context.stroke();
        context.closePath();
        context.restore();
      }
      Graph.prototype.drawEquation = function(equation, color, thickness) {
        var context = this.context;
        context.save();
        context.save();
        this.transformContext();

        context.beginPath();
        context.moveTo(this.minX, equation(this.minX));

        for(var x = this.minX + this.iteration; x <= this.maxX; x += this.iteration) {
          context.lineTo(x, equation(x));
        }

        context.restore();
        context.lineJoin = 'round';
        context.lineWidth = thickness;
        context.strokeStyle = color;
        context.stroke();
        context.restore();
      };

      Graph.prototype.transformContext = function() {
        var context = this.context;

        // move context to center of canvas
        this.context.translate(this.centerX, this.centerY);

        /*
         * stretch grid to fit the canvas window, and
         * invert the y scale so that that increments
         * as you move upwards
         */
        context.scale(this.scaleX, -this.scaleY);
      };
      
      var myGraph = new Graph({
        canvasId: 'myCanvas',
        minX: <%=-auxiliarVectorX.get(auxiliarQuantity-1)-ticks%>,
        minY: <%=-auxiliarVectorY.get(auxiliarQuantity-1)-ticks%>,
        maxX: <%=auxiliarVectorX.get(auxiliarQuantity-1)+ticks%>,
        maxY: <%=auxiliarVectorY.get(auxiliarQuantity-1)+ticks%>,
        unitsPerTick: <%=ticks%>
      });

      myGraph.drawEquation(function(x) {
        return <%
        switch(option){
            case 1:
                out.print("("+result[0]+")*x + ("+result[1]+");");
            break;
            case 2:
                out.print("("+result[0]+")*Math.exp(("+result[1]+")*Math.pow((x+("+result[2]+")),2))");
            break;
            case 3:
                out.print("("+result[2]+")*Math.pow(x,2)+("+result[1]+")*x+("+result[0]+")");
            break;
            case 4:
                out.print("("+result[0]+")*Math.exp(("+result[1]+")*x)");
            break;
        }
        
        %>;
      }, 'blue', 3);
      //myGraph.drawEquation(function(x) {return -1*x},'red',3);
      <%for(i=0;i<auxiliarQuantity;i++){ %>
      myGraph.drawPoint(<%=vectorX[i]%>,<%=vectorY[i]%>);
      <%}%>
    </script>
    </body>
</html>
