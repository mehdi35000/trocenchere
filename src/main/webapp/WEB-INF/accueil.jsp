<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<!-- <link rel="stylesheet" type="text/css" href="/webapp/CSS/commun.css"> -->
<style>
.article {
	border: 1px solid #ccc; /* Bordure autour de chaque article */
	padding: 10px; /* Espace intérieur pour le contenu de l'article */
	margin-bottom: 20px; /* Marge inférieure pour séparer les articles */
}
</style>
</head>
<body>
	<div class="container bg-warning-subtle">
		<header class="row justify-content-center">
        <div class="col text-center">
				<h1>Liste des enchères</h1>
			</div>
		</header>
	</div>
	
	<c:forEach items="${articlesEnVente}" var="article">
		<div class="article">
			<h2>${article.nom_article}</h2>
			<p>Date de début d'enchères : ${article.date_debut_encheres}</p>
			<p>Date de fin d'enchères : ${article.date_fin_encheres}</p>
			<p>Prix initial : ${article.mise_a_prix}</p>
			<p>Vendeur : ${article.utilisateur.pseudo}</p>
		</div>
	</c:forEach>

	<c:if test="${empty pseudoUtilisateur}">
		<a href="ServletConnexion">S'inscrire - se connecter</a>
	</c:if>

	<c:if test="${not empty pseudoUtilisateur}">
		<a href="ServletVendreUnArticle">Vendre un article</a>
		<a href="ServletMonProfil">Mon profil</a>
		<a href="ServletDeconnexion">Déconnexion</a>

		<h2>Bienvenue, ${pseudoUtilisateur}</h2>
	</c:if>


</body>
</html>

</body>
</html>