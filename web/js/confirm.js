/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function goServlet(divid,arq)
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

function desvincular(id_menu,id_perfil,op){
    var url="gerenciar_menu_perfil.do?id_menu="+id_menu+"&id_perfil="+id_perfil+"&op="+op;
    var resposta=confirm("Tem certeza que deseja excluir?\nclique em ok para confirmar ou em cancelar para desistir");
    if(resposta){
        goServlet('subcontent',url);
    }
}

function vincular(id_menu,id_perfil,op){
    var url="gerenciar_menu_perfil.do?id_menu="+id_menu+"&id_perfil="+id_perfil+"&op="+op;
    goServlet('subcontent',url);
}

function confirma(uri,id){
    var url=uri+"?id="+id;
    var resposta=confirm("Tem certeza que deseja excluir?\nclique em ok para confirmar ou em cancelar para desistir");
    if(resposta){
        window.open(url,"_parent");
    }
}

