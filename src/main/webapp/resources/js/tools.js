function validString(str) {
	return ((str != undefined) && (str.length > 0));
}

function errorAlert(error) {
	alert("[Error] : "+JSON.stringify(error));
}

function isAMail(mail) {
    var regex = /\S+@\S+\.\S+/;
    return regex.test(mail);
}

function logout() {
	removeCookie("key");
	removeCookie("login");
	window.location.href = "index.html";
}

/*
	COOKIES
*/
function createCookie(name,value,days) {
	if (days) {
		var date = new Date();
		date.setTime(date.getTime()+(days*24*60*60*1000));
		var expires = "; expires="+date.toGMTString();
	}
	else var expires = "";
	document.cookie = name+"="+value+expires+"; path=/";
}

function getCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return undefined;
}

function removeCookie(name) {
	createCookie(name,"",-1);
}