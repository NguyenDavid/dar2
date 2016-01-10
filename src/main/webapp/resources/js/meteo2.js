function showMeteo(){
	var meteo = document.createElement("script");
  	meteo.type = "text/javascript";
  	meteo.src = "http://api.openweathermap.org/data/2.5/weather?q=Paris,fr&appid=bd82977b86bf27fb59a04b61b657fb6f&callback=meteo";
   	document.body.appendChild(meteo);
}

function meteo(json){
	var div = document.getElementById("meteo");
  	//var p = document.createElement("div");

	var img = document.createElement("img");
	img.width="680";
	img.height="250";

	var w = json.weather[0];
	var d = w.description; //description
	var k = json.main.temp; //degre kelvin
	var c = k - "273.15"; //degre celsius
	c = Math.round(c*100)/100; //arrondi
	
	if(d == "sky is clear"){
		img.src="../web-resources/assets/paris_sun1.jpg";
		d = "Temps clair";
	}

	else if(d == "broken clouds" || d == "few clouds" || d == "scattered clouds"){
		img.src="../web-resources/assets/paris_cloud1.jpg";
		d = "Temps nuageux";
	}

	else if(d == "overcast clouds" || d == "rain" || d == "light rain"){
		img.src="../web-resources/assets/paris_rain1.jpg";
		d = "Risque de pluie";
	}

	else if(d == "fog"){
		img.src="../web-resources/assets/paris_fog1.jpg";
		d = "Temps brumeux";
	}

	else if(d == "light snow" || d == "snow"){
		img.src="../web-resources/assets/paris_rain1.jpg";
		d = "Temps neigeux";
	}

	else img.src="../web-resources/assets/paris_sun1.jpg";



	img.alt="&quot;"+d+": "+c+"&deg;C"+"&quot;";
	img.onclick="bonjour()";

//   	p.textContent = "<img  width=\"680\" height=\"250\" src=\"images/paris_cloud1.jpg\" alt=\"&quot;"+json.weather.description+"&quot;\" onclick=\"bonjour()\"; "
   	

	div.appendChild(img);
}



setInterval(showMeteo(), 3000);
