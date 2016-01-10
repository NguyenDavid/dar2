var selectedCommentState;
var commentStates = ["Unknow", "Like", "Warning", "Dislike"];

function main() {
	selectedCommentState = 1;
	
	$("#postTA").keyup(function(){
		$("#postlenght").text($(this).val().length+"/255");
	});
	
	$('body').on('click', '.btn-group button', function (e) {
	    $(this).addClass('active');
	    $(this).siblings().removeClass('active');	    
	});
}

function selectCommentState(state) {
	selectedCommentState = state;
}

function sendComment(form) {
	var text = form.postTA.value;

	if (text.length < 5) {
		alert("Votre commentaire doit faire au moins 6 characteres");
		return;
	}
	
	if (text.length > 139) {
		alert("Votre commentaire doit faire au maximum 140 characteres");
		return;
	}

	console.log("Send comment : '"+text+"' with state "+commentStates[selectedCommentState]);
	
	$.ajax({
	   	type: "GET",
	   	url: "ADRESS/SendComment?mes="+text,
	   	dataType: "json",
	   	success: sendComment,
	   	error: errorAlert
	});
}

function sendCommentJSR(jsonData) {
	if (jsonData.c == "0")
		console.log("Envoie réussi !");
	else
		errorAlert(jsonData);
}