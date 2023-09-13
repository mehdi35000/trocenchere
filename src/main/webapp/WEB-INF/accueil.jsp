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
<link rel="stylesheet" type="text/css" href="CSS/commun.css">
</head>
<body>
	<main class="container">
		<article class="grid">
			<nav class="navbar navbar-expand-lg bg-body-tertiary">
				<div class="container-fluid">

					<c:if test="${empty idUtilisateur}">
						<a class="navbar-brand" href="ServletConnexion"> S'inscrire -
							se connecter</a>
						<button class="navbar-toggler" type="button"
							data-bs-toggle="collapse"
							data-bs-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
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
					</c:if>
				</div>
			</nav>
			<br> <br>
			
			<form id="toggleForm">
				<input type="radio" name="toggle" value="achats" checked>Achats
				<input type="radio" name="toggle" value="ventes">Mes Ventes
				<br>
				<input type="submit" value="Afficher">
			</form>
		<br> <br>
		</article>
		<h3>Liste des enchères</h3>
		<br><br>
		<br> <br>
		<div id="ListeDesEncheres">
			<div class="row row-cols-1 row-cols-md-3 g-4">
				<c:forEach items="${articlesEnVente}" var="article">

					<div class="col">
						<div class="card shadow hover">
							<img src="Image/petitcochon.png" class="card-img-top"
								alt="imageEnchere">
							<div class="card-body">
								<h5 class="card-title">
									<a href="ServletEncherir?id_Article=${article.id_Article}"
										data-id="${article.id_Article}">${article.nom_article}</a>
								</h5>
								<p class="card-text">Date de début d'enchères :
									${article.date_debut_encheres}</p>
								<p class="card-text">Date de fin d'enchères :
									${article.date_fin_encheres}</p>
								<p class="card-text">Prix initial : ${article.mise_a_prix}</p>
								<p class="card-text">Vendeur : ${article.utilisateur.pseudo}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>
		<br> <br>
		<div id="ListeDeMesVentes">
			<h3>Mes articles en vente</h3>

			<br> <br>

			<div class="row row-cols-1 row-cols-md-3 g-4">
				<c:forEach items="${mesArticlesEnVente}" var="article">

					<div class="col">
						<div class="card shadow hover">
							<img src="Image/galeriendetrocenchere.jpg" class="card-img-top"
								alt="imageEnchere">
							<div class="card-body">
								<h5 class="card-title">

									<a href="ServletEncherir?id_Article=${article.id_Article}"
										data-id="${article.id_Article}">${article.nom_article}</a>
								</h5>
								<p class="card-text">Date de début d'enchères :
									${article.date_debut_encheres}</p>
								<p class="card-text">Date de fin d'enchères :
									${article.date_fin_encheres}</p>
								<p class="card-text">Prix initial : ${article.mise_a_prix}</p>
								<p class="card-text">Vendeur : ${article.utilisateur.pseudo}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</main>
</body>
</html>