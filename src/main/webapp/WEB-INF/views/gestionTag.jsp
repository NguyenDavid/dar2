<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN">

<html>
<head>
	<link rel="stylesheet" href='<c:url value="/web-resources/css/bootstrap.css"/>'>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
	<link rel="stylesheet" href='<c:url value="/web-resources/css/custom.css"/>'>
	<link rel="stylesheet" href='<c:url value="/web-resources/css/bootstrap.min.css"/>'>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>	
	<div class="navbar-inner">
        <div class="container">
        	<!--<form:form modelAttribute="user" class="form-horizontal" action="user" method="get">-->
	            <div class="row">
					<div class="col-md-4">
					</div>
					
					<div class="col-md-4">
						<!-- Add Tag(s) -->
						<ul class="nav nav-pills nav-stacked">
							<form:form modelAttribute="tag" class="form-horizontal" action="save" method="post">
							<div class="radio">
									<center><input type="text" name="text" size="40"/></center>
							</div>
							<br/>
							<button type="submit" class="btn btn-lg btn-primary form-control">Ajouter tag</button>
							</form:form>
						</ul>
						
						<br/>
						<br/>
						
						<!-- Delete Tag(s) -->
						<ul class="nav nav-pills nav-stacked">
							
							<center><label class="btn-default">Liste des tags :</label></center>
							<form:form modelAttribute="tag" class="form-horizontal" action="delete" method="post">
							<div class="radio">
								<c:forEach items="${tagList}" var="tag">
									<label><input type="checkbox" name="optcheck" value="${tag.nom}">${tag.nom}</label></br>
								</c:forEach>
							</div>
							<br/>
							<button type="submit" class="btn btn-lg btn-danger form-control">Supprimer tag(s)</button>
							</form:form>
							
						</ul>
					</div>
					
					<div class="col-md-4">
					</div>
	
				</div>
			<!--</form:form>-->
        </div><!-- end of .container -->
    </div><!-- end of .navbar-inner -->

	

</body>
</html>