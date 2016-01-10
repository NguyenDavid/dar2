<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN">

<html>
<head>
	<title>BreakFirst Game</title>
	     <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAsIEm67g2EcheXmrxxBgh6Jq5TKLmi2sk&signed_in=true&callback=initialiser"
         async defer></script>
	<!--
	<link rel="stylesheet" href='<c:url value="/web-resources/css/bootstrap.css"/>'>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href='<c:url value="/web-resources/css/custom.css"/>'>
	<link rel="stylesheet" href='<c:url value="/web-resources/css/bootstrap.min.css"/>'>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	-->
	<link rel="stylesheet" type="text/css" href='<c:url value="/web-resources/css/style.css"/>' />
<!-- 	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script> -->
	<title>Projet DAR</title>
	
	<script type="text/javascript">
	
	function attachMessage(marker, nomCafe) {
		  var infowindow = new google.maps.InfoWindow({
		    content: nomCafe
		  });

		  marker.addListener('click', function() {
		    infowindow.open(marker.get('map'), marker);
		  });
		}
	
	function initialiser() {
		var latlng = new google.maps.LatLng('${cafeList[0].x}', '${cafeList[0].y}');
		//objet contenant des propriétés avec des identificateurs prédéfinis dans Google Maps permettant
		//de définir des options d'affichage de notre carte
		var options = {
			center: latlng,
			zoom: 13,
			mapTypeId: google.maps.MapTypeId.ROADMAP
		};
		
		var carte = new google.maps.Map(document.getElementById("carte"), options);
		var listeCoord = new Array();

 		<c:forEach items="${cafeList}" var="cafe">
			var xy = new google.maps.LatLng('${cafe.x}', '${cafe.y}');
			listeCoord.push({
				location : xy,
				stopover: true
			});
			
			var marker = new google.maps.Marker({
			    position: xy,
			    map: carte,

			});
			
			var infowindow = new google.maps.InfoWindow({
			    content: '${cafe.nom}'
			});

			attachMessage(marker, '${cafe.nom}');

 	    </c:forEach>
 	   
 	   var length = ${cafeList.size()};
 	   if(length > 1){
 		  var directionsService = new google.maps.DirectionsService;
 		  var directionsDisplay = new google.maps.DirectionsRenderer;
 		  
 			  var debut = listeCoord[0].location;
 			  var fin = listeCoord[length-1].location;
 	 		  directionsService.route({
 					origin: debut,
 					destination: fin,
 					waypoints: listeCoord,
 					optimizeWaypoints: true,
 				    travelMode: google.maps.TravelMode.DRIVING
 				  }, function(response, status) {
 				    if (status === google.maps.DirectionsStatus.OK) {
 				      directionsDisplay.setDirections(response);
 				    } else {
 				      window.alert('Directions request failed due to ' + status);
 				    }
 				  });
  	 		 directionsDisplay.setMap(carte);
  	 		directionsDisplay.setOptions({suppressMarkers:true});
 	   }
 	
		}

		function map() {
			if (document.getElementById("carte").style.height > "100px") {
				var height = document.getElementById("carte").style.height;
				document.getElementById("carte").style.height = "0px";
			} else {
				document.getElementById("carte").style.height = "420px";
				initialiser();
			}
		}
	</script>
	
</head>

<body onload="initialiser();">

	<input  id="list" type="hidden" name="List" value="${cafeList}">

	<div id="main">
		<div id="header">
			<div id="banner">
				<div id="welcome">
					<div>
						<img id="gl" src='<c:url value="/web-resources/assets/GrandLogo.png"/>' alt="image1" align="right" width="230" height="150" />
					</div>
					<br />
					<h1>BreakFirst Game</h1>

				</div>
				<!--close welcome-->
				<div id="welcome_slogan">
					<h1>Paris</h1>

				</div>
				<!--close welcome_slogan-->
			</div>
			<!--close banner-->
		</div>
		<!--close header-->

		<div id="menubar">
			<ul id="menu">
				<li><a href="home">Home</a></li>
				<li><a href="homeCafe">Liste des cafés</a></li>
				<li class="active"><a href="askCafe">Cherche itinéraire</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</div>
		<!--close menubar-->

		<div id="site_content">
			<div>
				<form:form modelAttribute="cafe" class="form-horizontal" action="showOneCafe" method="post">
					<div class="row">
						<div class="col-md-12">
							<br/>
							<label><h2>Cherche café(s)</h2></label>
							
							<c:if test="${nombreCafe=='1'}">
								<label><i>1 seul café ? Petit joueur...</i></label>
								<br/>
							</c:if>
							<c:if test="${nombreCafe=='5'}">
								<label><i>5 cafés ? Ca commence à faire beaucoup !</i></label>
								<br/>
							</c:if>
							<c:if test="${nombreCafe=='8'}">
								<label><i>8 cafés ? Oublie pas de prendre une pause pour manger !</i></label>
								<br/>
							</c:if>
							
							<br/>
						</div>
					</div>
					
		            <div class="row">
						<div class="col-md-3">
							<ul>		
								<c:forEach items="${cafeList}" var="cafe">
									<li><a href='<c:url value="showOneCafe?nom=${cafe.nom}"/>'>${cafe.nom}</a></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</form:form>
			</div>
			
<!-- 		<a href=# id="map" onclick="map();">Activer Google Maps</a>  -->
			<div id="carte" style="width: 650px; height: 420px;"></div>
			<br/>
			
		</div><!--close site_content-->
		<br/>

	</div><!--close main-->
  
  <jsp:include page="planDuSite.jsp"></jsp:include>  
    
</body>
</html>