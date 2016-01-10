<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>BreakFirst Game</title>
	<link rel="stylesheet" type="text/css" href='<c:url value="/web-resources/css/style.css"/>' />
	<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
	
	<script type="text/javascript">
	
		function initialiser() {
			var latlng = new google.maps.LatLng('${cafe.x}', '${cafe.y}');
			//objet contenant des propriétés avec des identificateurs prédéfinis dans Google Maps permettant
			//de définir des options d'affichage de notre carte
			var options = {
				center: latlng,
				zoom: 13,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			};
			
			var carte = new google.maps.Map(document.getElementById("carte"), options);
	
			var xy = new google.maps.LatLng('${cafe.x}', '${cafe.y}');
			var marker = new google.maps.Marker({
			    position: xy,
			    map: carte,
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

<body onload="initialiser();">

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
				<li><a href="askCafe">Cherche itinéraire</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</div>
		<!--close menubar-->

		<div id="site_content">
			<div>
					<div class="row">
						<div class="col-md-12">
							<br/>
							<label><h2>Cherche café(s)</h2></label>
							<br/>
						</div>
					</div>
					
					
					<div class="row">
						<div class="col-md-5">
							<c:choose>
								<c:when test="${erreur}">
									<font size="1" color="red">
										<label><i>Erreur, pas de café</i></label>
									</font>
									<br/>
								</c:when>
								<c:otherwise>
									<p>Nom du café : ${cafe.nom}</p>
									<p>Coordonnées : (${cafe.x};${cafe.y})</p>
									<p>Arrondissement : ${cafe.arrondissement}</p>
									<p>Adresse : ${cafe.adresse}</p>
								</c:otherwise>
							</c:choose>	
						</div>
					</div>
					
					
<!-- 					<a href=# id="map" onclick="map();">Activer Google Maps</a> -->
					<div onload="map();"  id="carte" style="width: 300px; height: 300px;"></div>
					<br/>
					
						
					<div class="row">
						<div class="col-md-12">
							<br/>
							<label><h2>Liste des commentaires</h2></label>
							<br/>
						</div>
					</div>
					
					
					<div class="row">
						<div class="col-md-5">
							<ul>
								<c:forEach items="${commentairesList}" var="com">
									<li><label>Auteur : </label><label>${com.owner}</label>
									<br/>
									<p>${com.contenu}</p>
									</li>
									<br/>
								</c:forEach>
							</ul>
							<br/>
							<form:form modelAttribute="cafe" class="form-horizontal" action="addCom" method="post" accept-charset="ISO-8859-1">
								<input type="text" name="contenu" size=100)/>
								<input type="hidden" name="nom" value='${cafe.nom}'/>
								<br/>
								<button type="submit" class="btn btn-lg btn-danger form-control">Ajouter commentaire</button>
							</form:form>
						</div>
					</div>
					<br/>
			</div>
		</div><!--close site_content-->
		<br/>

	</div><!--close main-->
  
  <jsp:include page="planDuSite.jsp"></jsp:include>
  
</body>
</html>