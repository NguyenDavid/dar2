<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!--
	<link rel="stylesheet" href='<c:url value="/web-resources/css/bootstrap.css"/>'>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href='<c:url value="/web-resources/css/custom.css"/>'>
	<link rel="stylesheet" href='<c:url value="/web-resources/css/bootstrap.min.css"/>'>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	-->
	<link rel="stylesheet" type="text/css" href='<c:url value="/web-resources/css/style.css"/>' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BreakFirst Game</title>
</head>

<body onload="initialiser();map();">

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
				<li class="active"><a href="#">Cherche itinéraire</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</div>
		<!--close menubar-->

		<div id="site_content">
			<div>
				<form:form modelAttribute="cafe" class="form-horizontal" action="showCafe" method="post">
					<div class="row">
						<div class="col-md-12">
							<br/>
							<label><h2>Cherche café(s)</h2></label>
							<br/>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-5">
							<font size="1" color="red">
								<c:if test="${erreur}">
									<label><i>Erreur, nombre et/ou arrondissement manquant(s)</i></label>
									<br/>
								</c:if>
							</font>
							<label>Nombre de café(s) :</label>
							<input type="text" name="nombre" size="1" maxlength=1/>
							<label>(entre 1 et 8)</label>
							<br/>
							<br/>
							<label>Numéro de l'arrondissement :</label>
							<input type="text" name="arrondissement" size="1" maxlength=2/>
							<label>(entre 1 et 20)</label>
							<br/>
							<br/>
							<button type="submit" class="btn btn-lg btn-primary form-control">Cherche café(s)</button>
							
						</div>
					</div>
					<br/>
				</form:form>
			</div>
		</div><!--close site_content-->
		<br/>

	</div><!--close main-->

  <jsp:include page="planDuSite.jsp"></jsp:include>
  
</body>
</html>