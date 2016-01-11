<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BreakFirst Game</title>
	<link rel="stylesheet" type="text/css" href='<c:url value="/web-resources/css/style.css"/>' />
	<script type="text/javascript" src='<c:url value="/web-resources/js/jquery.min.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/js/image_slide.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/js/login.js"/>'></script>
	<script type="text/javascript" src='<c:url value="/web-resources/js/meteo2.js"/>'></script>

	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<!-- Elément Google Maps indiquant que la carte doit être affiché en plein écran et
	qu'elle ne peut pas être redimensionnée par l'utilisateur -->
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	<!-- Inclusion de l'API Google MAPS -->
	<!-- Le paramètre "sensor" indique si cette application utilise détecteur pour déterminer la position de l'utilisateur -->
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
	<script type="text/javascript">


			function initialiser() {
				var latlng = new google.maps.LatLng(48.8464111, 2.3548468);
				//objet contenant des propriétés avec des identificateurs prédéfinis dans Google Maps permettant
				//de définir des options d'affichage de notre carte
				var options = {
					center: latlng,
					zoom: 19,
					mapTypeId: google.maps.MapTypeId.ROADMAP
				};
				
				//constructeur de la carte qui prend en paramêtre le conteneur HTML
				//dans lequel la carte doit s'afficher et les options
				var carte = new google.maps.Map(document.getElementById("carte"), options);
				
				var marker = new google.maps.Marker({
				    position: latlng,
				    map: carte,
				    title: 'Hello World!'
				  });
				marker.setMap(carte);
			}


			function map(){
				if(document.getElementById("carte").style.height > "100px"){
					var height = document.getElementById("carte").style.height;
					document.getElementById("carte").style.height = "0px";
				}else{
					document.getElementById("carte").style.height = "420px";
					initialiser();
				}
			}
	
		</script>
	
	
</head>

<!--  
	<div><img id="gl" src='<c:url value="/web-resources/assets/GrandLogo.png"/>' alt="image1" align="right" width="230" height="150" /> </div>
	<a href="login.jsp">Login</a>
-->

<body onload="showMeteo();initialiser();map();">

	<div id="main">
		<div id="header">
			<div id="banner">
				<div id="welcome">
					<div>
						<img id="gl" src='<c:url value="/web-resources/assets/GrandLogo.png"/>' alt="image1" align="right" width="230" height="150" />
					</div>
					<br />
					<h1>BreakFirst Game</h1>
					
				</div><!--close welcome-->
				<div id="welcome_slogan">
					<h1>Paris</h1>

				</div><!--close welcome_slogan-->
			</div><!--close banner-->
		</div><!--close header-->

		<div id="menubar">
			<ul id="menu">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="homeCafe">Liste des cafés</a></li>
				<li><a href="askCafe">Cherche itinéraire</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</div><!--close menubar-->

		<div id="site_content">

			<div class="sidebar_container">
				<div class="sidebar">
					<div class="sidebar_item">
						<h2>Derniers commentaires :</h2>
						<h3></h3>
						<c:forEach items="${commentaireList}" var="com">
							<li><label>${com.cafe.nom} : ${com.contenu}</label></li>
							<br/>
						</c:forEach>
						<p></p>
					</div><!--close sidebar_item-->
				</div><!--close sidebar-->
				<div class="sidebar">
					<div class="sidebar_item">
						<h3></h3>
						<p></p>
					</div><!--close sidebar_item-->
				</div><!--close sidebar-->
				<div class="sidebar">
					<div class="sidebar_item">
						<h3></h3>
						<p></p>
					</div><!--close sidebar_item-->
				</div><!--close sidebar-->
				<div class="sidebar">
					<div class="sidebar_item">
						
					</div><!--close sidebar_item-->
				</div><!--close sidebar-->
			</div><!--close sidebar_container-->

			<div class="slideshow">
				<ul class="slideshow">
					<li class="show"><img width="680" height="250"
						src='<c:url value="/web-resources/assets/paris2.jpg"/>'
						alt="&quot;Choose your destination&quot;" onclick="bonjour();" /></li>
					<div id="meteo"></div>
				</ul>
			</div>

			<div id="content">
				<div class="content_item">
					<h1>Bienvenue!</h1>

					<br />

					<div class="content_image">
						<img src='<c:url value="/web-resources/assets/paris6.jpg"/>'
							alt="image1" width="150" height="150" />
					</div>
						<p>
							<label>Principe :</label>
							<br/>
							<label> - repérer les cafés à un euro</label>
							<br/>
							<label> - choisir un itinéraire de 1 à 8 café(s)</label>
							<br/>
							<label> - poster des commentaires sur vos cafés préférés</label>
							<br/>
						</p> 
				

					
					<br style="clear: both" />
			
					</div><!--close content_container-->
				</div><!--close content_item-->
			</div><!--close content-->

		</div><!--close site_content-->
	</div><!--close main-->
	
	<jsp:include page="planDuSite.jsp"></jsp:include>
</body>
</html>
