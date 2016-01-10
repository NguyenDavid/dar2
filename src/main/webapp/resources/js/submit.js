var selectedMedia;
var medias = ["Unknow", "Facebook", "Twitter", "YouTube"];

function main() {
	selectedMedia = 1;
	
	$("#postTA").keyup(function(){
		$("#postlenght").text($(this).val().length+"/255");
	});
	
	$('body').on('click', '.btn-group button', function (e) {
	    $(this).addClass('active');
	    $(this).siblings().removeClass('active');	    
	});
}

function selectMedia(sele) {
	selectedMedia = sele;
}

function sendPublication(form) {
	var text = form.postTA.value;

	if (text.length < 5) {
		alert("Votre message doit faire au moins 6 characteres");
		return;
	}
	
	if (text.length > 139) {
		alert("Votre message doit faire au maximum 140 characteres");
		return;
	}

	console.log("Send message : '"+text+"' on "+medias[selectedMedia]);
	
	$.ajax({
	   	type: "GET",
	   	url: "ADRESS/SendPublication?mes="+text,
	   	dataType: "json",
	   	success: sendPublicationJSR,
	   	error: errorAlert
	});
}

function sendPublicationJSR(jsonData) {
	if (jsonData.c == "0")
		console.log("Envoie réussi !");
	else
		errorAlert(jsonData);
}