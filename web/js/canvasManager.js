/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function canvasText(canvid,text,wd,hg){
    var canvas = document.getElementById(canvid);
    canvas.setAttribute("width",wd);
    canvas.setAttribute("height",hg);
    var context = canvas.getContext("2d");
    context.fillRect(0,0,wd,hg);
    context.font = '24pt Calibri';
    context.fillStyle='blue';
    context.textAlign = 'center';

    context.fillText(text,wd/2,hg/2);
    
}