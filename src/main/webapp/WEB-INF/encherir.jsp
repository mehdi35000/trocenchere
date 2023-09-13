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
	
	<h3><p>${article.nom_article}</p></h3>
	
	<br>
	<p>Description :<c:out value="${article.description}" /></p>

	<br>
	<p>Catégorie : ${article.categorie.libelle}</p>
	<br>
	<p>Meilleur offre :</p>
	<br>
	<p>Mise à prix :${article.mise_a_prix}</p>
	<br>
	<p>Fin de l'enchère : ${article.date_fin_encheres}</p>
	<br>
	<p>Retrait : ${article.retrait.rue}</p>
	<p> ${article.retrait.codePostal } </p>
	<p> ${article.retrait.ville } </p>
	<br>
	<br>
	<p>Vendeur :${article.utilisateur.pseudo} </p>
	<br>
	
	<form action="ServletEncherir" method="POST">
	
	<label for="enchere"> ma proposition :</label>
	<input type="hidden" id="id_Article" name="id_Article" value="${article.id_Article }">
	
	<input type="number" id="enchere" name="enchere" min="1" max="100000">
	<br>
	<input type="submit" value="Encherir">
	</form>	
</body>
</html>