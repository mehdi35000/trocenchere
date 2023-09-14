<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<title>Accueil</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
<link rel="stylesheet" type="text/css" href="CSS/commun.css">

</head>
<body>
	<main class="container">
		<article class="grid">
			<nav class="navbar navbar-expand-lg bg-body-tertiary">
				<div class="container-fluid">

					<c:if test="${empty idUtilisateur}">
						<a href="ServletConnexion">S'inscrire - se connecter</a>
						<div id="ListeDesEncheres">
							<c:forEach items="${ListeEncheres}" var="article">
								<div class="article">
									<h2>
										<a href="ServletEncherir?id_Article=${article.id_Article}"
											data-id="${article.id_Article}">${article.nom_article}</a>
									</h2>
									<%--  <h2> <a href ="ServletEncherir"> ${article.nom_article}</a></h2> --%>
									<p>Date de début d'enchères :
										${article.date_debut_encheres}</p>
									<p>Date de fin d'enchères : ${article.date_fin_encheres}</p>
									<p>Prix initial : ${article.mise_a_prix}</p>
									<p>Vendeur : ${article.utilisateur.pseudo}</p>
								</div>
							</c:forEach>
						</div>
					</c:if>


					<c:if test="${not empty idUtilisateur}">
						<h2>Bienvenue, ${pseudoUtilisateur}</h2>
						<br>
						<a class="navbar-brand" href="ServletVendreUnArticle">Vendre
							un article</a>
						<a class="navbar-brand" href="ServletMonProfil">Mon profil</a>
						<a class="navbar-brand" href="ServletDeconnexion">Déconnexion</a>
						<button class="navbar-toggler" type="button"
							data-bs-toggle="collapse"
							data-bs-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
				</div>
			</nav>
			<br> <br>

			<!--  <form id="toggleForm">-->
				<!--  <input type="radio" name="toggle" value="achats" checked>Achats-->
				<!--  <input type="radio" name="toggle" value="ventes">Mes Ventes-->	
				
				<form id="toggleOption" action="ServletAccueil" method="post">
				
				<!--  <div id="achatsFilters">-->
								<input type="radio" name="toggleOption" value="encheres" id="enchèresCheckbox">
								<label for="enchèresCheckbox">Enchères</label>
								<input type="radio" name="toggleOption" value="mesEnchères" id="mesEnchèresCheckbox">
								<label for="mesEnchèresCheckbox">Mes enchères</label> 
								<input type="radio" name="toggleOption" value="mesEnchèresRemportées"	id="mesEnchèresRemportéesCheckbox"> 
								<label for="mesEnchèresRemportéesCheckbox">Mes enchères emportées</label>
								
								<!--  <input type="submit" value="Afficher">-->
				<!-- <div id="ventesFilters">-->
								<input type="radio" name="toggleOption" value="mesVentesEnCours" id="mesVentesEnCoursCheckbox">
								<label for="mesVentesEnCoursCheckbox">Mes ventes en cours</label> 
								<input type="radio" name="toggleOption" value="mesVentesAVenir" id="mesVentesAVenirCheckbox">
								<label for="mesVentesAVenirCheckbox">Mes ventes programmées</label> 
								<input type="radio" name="toggleOption" value="mesVentesTerminees"	id="mesVentesTermineesCheckbox"> 
								<label for="mesVentesTermineesCheckbox">Mes ventes terminées</label>
								
								<input type="submit" value="Filtrer">
			</form>
			<%-- 
			<form id="toggleForm" action="ServletAccueil" method="post">
				
				<!--  <div id="achatsFilters">-->
								<input type="checkbox" name="enchères" id="enchèresCheckbox">
								<label for="enchèresCheckbox">Enchères</label>
								<input type="checkbox" name="mesEnchères" id="mesEnchèresCheckbox">
								<label for="mesEnchèresCheckbox">Mes enchères</label> 
								<input type="checkbox" name="mesEnchèresRemportées"	id="mesEnchèresRemportéesCheckbox"> 
								<label for="mesEnchèresRemportéesCheckbox">Mes enchères emportées</label>
								
								<!--  <input type="submit" value="Afficher">-->
				<!-- <div id="ventesFilters">-->
								<input type="checkbox" name="mesVentesEnCours" id="mesVentesEnCoursCheckbox">
								<label for="mesVentesEnCoursCheckbox">Mes ventes en cours</label> 
								<input type="checkbox" name="mesVentesAVenir" id="mesVentesAVenirCheckbox">
								<label for="mesVentesAVenirCheckbox">Mes ventes programmées</label> 
								<input type="checkbox" name="mesVentesTerminees"	id="mesVentesTermineesCheckbox"> 
								<label for="mesVentesTermineesCheckbox">Mes ventes terminées</label>
								
								<input type="submit" value="Filtrer">
			</form>
			--%>
			<br> <br>
		</article>
		</c:if>
		
		<div id="ListeDesEncheres">
			<c:forEach items="${ListeEncheres}" var="article">
				<!--  <div class="article">-->
				<div class="col">
					<div class="card shadow hover">
						<img src="Image/galeriendetrocenchere.jpg" class="card-img-top"
							alt="imageEnchere">
						<div class="card-body">
							<h5 class="card-title">
								<h2>
									<a href="ServletEncherir?id_Article=${article.id_Article}"
										data-id="${article.id_Article}">${article.nom_article}</a>
								</h2>
								<%--  <h2> <a href ="ServletEncherir"> ${article.nom_article}</a></h2> --%>
								<p>Date de début d'enchères : ${article.date_debut_encheres}</p>
								<p>Date de fin d'enchères : ${article.date_fin_encheres}</p>
								<p>Prix initial : ${article.mise_a_prix}</p>
								<p>Vendeur : ${article.utilisateur.pseudo}</p>
						</div>
			</c:forEach>
		</div>
	</main>
</body>
</html>