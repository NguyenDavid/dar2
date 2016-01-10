<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>BreakFirst Game</title>
	<link rel="stylesheet" href='<c:url value="/web-resources/css/bootstrap.css"/>'/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href='<c:url value="/web-resources/css/custom.css"/>'/>
	<link rel="stylesheet" type="text/css" href='<c:url value="/web-resources/css/style3.css"/>' />
</head>

<body>
	<div id="content-wrapper">
		<div id="page-inner">

			<!-- FOREACH PUBLI in PUBLICATION -->
			<div class="col-md-4 col-centered margin-top-xl">
				<div class="panel panel-back noti-box">
					<img src='<c:url value="/web-resources/assets/GrandLogo.jpg"/>' alt="logo" class="img-logo-small center-block"> <br />
					
					<c:if test="${erreur}">
						<label><i>Erreur, ${msg}</i></label>
						<br/>
					</c:if>
					
					<form:form modelAttribute="user" class="form-horizontal" action="register" method="post">

						<div class="input-group margin-bottom-lg">
							<span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
							<form:input path="email" class="form-control" placeholder="Adresse e-mail (Nom d'utilisateur)"></form:input>
						</div>
						<div class="input-group margin-bottom-sm">
							<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
							<form:input path="arrondissement" class="form-control" placeholder="Arrondissement"></form:input>
						</div>
						<div class="input-group  margin-bottom-sm">
							<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
							<form:password path="password" class="form-control" placeholder="Mot de passe"></form:password>
						</div>
						
						<div class="input-group  margin-bottom-lg">
							<span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
							<input type="password" class="form-control" placeholder="Confirmer le mot de passe">
						</div>

						<button type="submit" class="btn btn-lg btn-primary form-control">Créer le profil</button>
					</form:form>
				</div>
			</div>
			<!-- END FOREACH -->

		</div>
	</div>
</body>
</html>
