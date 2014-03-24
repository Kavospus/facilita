/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function getPageGET(divid,arq,par1,str1,par2,str2)
{
    var xmlhttp;
    var second = "";

    if (str1.length==0)
    {
        document.getElementById(divid).innerHTML="";
        return;
    }

    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById(divid).innerHTML=xmlhttp.responseText;
        }
    }



    if(par2.length!=0){
        second = "&"+par2+"="+str2;
    }


    xmlhttp.open("GET",arq+"?"+par1+"="+str1+second,true);
    xmlhttp.send();




}

function getValue(id){
    return document.getElementById(id).value
}

function refreshPage(divid,arq)
{
    var xmlhttp;


    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById(divid).innerHTML=xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET",arq,true);
    xmlhttp.setRequestHeader("If-Modified-Since","Sat, 1 Jan 2000 00:00:00 GMT");
    xmlhttp.send();


}
function refreshPageDiv(div,arq)
{
    var xmlhttp;


    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            div.innerHTML=xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET",arq,true);
    xmlhttp.setRequestHeader("If-Modified-Since","Sat, 1 Jan 2000 00:00:00 GMT");
    xmlhttp.send();


}


function getPagePOST(divid,arq,par1,str1,par2,str2)
{
    var xmlhttp;
    var second = "";

    if (str1.length==0)
    {
        document.getElementById(divid).innerHTML="";
        return;
    }

    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            document.getElementById(divid).innerHTML=xmlhttp.responseText;
        }
    }

    if(par2.length!=0){
        second = "&"+par2+"="+str2;
    }

    var params = par1+"="+str1+second;

    xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencode");


    xmlhttp.open("POST",arq,true);
    xmlhttp.send(params);
}


