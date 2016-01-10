<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ProjetDAR</title>
</head>
<body>
	<form:form modelAttribute="commentaire" class="form-horizontal" action="saveCommentaire" method="post">
		<label>Votre commentaire</label>
		<input type="text" name="contenu" maxlength=100/>
		<button type="submit" class="btn btn-lg btn-primary form-control">Ajouter le commentaire</button>
	</form:form>
	<br/>
	
	<label>Liste des commentaires : </label>
	
	<br/>
	<c:forEach items="${commentaireList}" var="commentaire">
		<label>Contenu : ${commentaire.contenu}</label>
		<br/>
	</c:forEach>
</body>
</html>