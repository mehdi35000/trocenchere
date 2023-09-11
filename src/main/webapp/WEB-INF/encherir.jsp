<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Encherir</title>
</head>
<body>
	<h1>ENI-Enchères</h1>
	
	<h2>Détail vente</h2>
		<c:out value="${nomArticle}"></c:out>
	
	   	    <c:forEach items="${articlesEnVente}" var="article">
        <c:if test="${article.id_Article == param.id_Article}">
         <p>${article.nom_article}</p>
        </c:if>
    </c:forEach>
	<p>${article.nom_article}</p>
	<br>
	<p>Description :<c:out value="${article.description}" /></p>

	<br>
	<p>Catégorie : ${article.categorie}</p>
	<br>
	<p>Meilleur offre :</p>
	<br>
	<p>Mise à prix :</p>
	<br>
	<p>Fin de l'enchère :</p>
	<br>
	<p>Retrait :</p>
	<br>
	<p>Vendeur : </p>
	<p> Ma proposition<input type="number" id="enchere" name="enchere" min="1" max="100000" /></p>
	<a href=""><input type="button" value="Enchérir" /></a>
</body>
</html>