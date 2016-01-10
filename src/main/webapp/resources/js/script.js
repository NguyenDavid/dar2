//document.getElementById('demo').innerHTML = 'Hello JavaScript!';
//setCookie("trackingid",new Date().getTime());
/*var test = getCookie("trackingid");
var sp = test.split("=");
alert(sp[0]);*/
//alert(parent.document.cookie);
if(getCookie("trackingid")){
	var cook = getCookie("number_of_connections") 
	if(cook){
		var res = cook.split("=");
		var cpt = res[0];
		setCookie("number_of_connections",parseInt(cpt)+1);
					
	}
alert(document.cookie);
}
else{
setCookie("trackingid",new Date().getTime());
setCookie("number_of_connections",1);
alert(document.cookie);
}

//setCookie("trackingid",new Date().getTime());




function setCookie(sName, sValue) {

        var today = new Date(), expires = new Date();

        expires.setTime(today.getTime() + (365*24*60*60*1000));

        document.cookie = sName + "=" + encodeURIComponent(sValue) + ";expires=" + expires.toGMTString();

}

function getCookie(sName) {
        var cookContent = document.cookie, cookEnd, i, j;
        var sName = sName + "=";
 
        for (i=0, c=cookContent.length; i<c; i++) {
                j = i + sName.length;
                if (cookContent.substring(i, j) == sName) {
                        cookEnd = cookContent.indexOf(";", j);
                        if (cookEnd == -1) {
                                cookEnd = cookContent.length;
                        }
                        return decodeURIComponent(cookContent.substring(j, cookEnd));
                }
        }       
        return null;
}


function getCookie(sName) {

        var oRegex = new RegExp("(?:; )?" + sName + "=([^;]*);?");

 

        if (oRegex.test(document.cookie)) {

                return decodeURIComponent(RegExp["$1"]);

        } else {

                return null;

        }

}

    var xhr; 
    try {  xhr = new ActiveXObject('Msxml2.XMLHTTP');   }
    catch (e) 
    {
        try {   xhr = new ActiveXObject('Microsoft.XMLHTTP'); }
        catch (e2) 
        {
           try {  xhr = new XMLHttpRequest();  }
           catch (e3) {  xhr = false;   }
         }
    }
  
    xhr.onreadystatechange  = function() 
    {
    	
       if(xhr.readyState  == 4)
       {
        if(xhr.status  == 200) 
            document.ajax.dyn="Received:"  + xhr.responseText; 
        else
            document.ajax.dyn="Error code " + xhr.status;
        }
    };
   //xhr.open( "GET", "/sendDC?cookies="+document.cookie,  true);
    xhr.open( "GET", "../../sendDC?cookies="+document.cookie,  true);
   xhr.send(null);