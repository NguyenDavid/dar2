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
</head>
<body>
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
								<label>Plan du site</label>
								<ul>
									<li><a href="home">Home</a></li>
									<li><a href="homeCafe">Liste des cafés</a></li>
									<li><a href="askCafe">Cherche itinéraire</a></li>
								</ul>
							<br/>
						</div>
					</div>
				</div>
				
			</div><!--close site_content-->
			<br/>
	
		</div><!--close main-->
	  
	  <jsp:include page="planDuSite.jsp"></jsp:include>   
</body>
</html>