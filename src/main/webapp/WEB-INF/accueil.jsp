<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
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
					<p>Date de début d'enchères : ${article.date_debut_encheres}</p>
					<p>Date de fin d'enchères : ${article.date_fin_encheres}</p>
					<p>Prix initial : ${article.mise_a_prix}</p>
					<p>Vendeur : ${article.utilisateur.pseudo}</p>
				</div>
			</c:forEach>
		</div>
	</c:if>

	<c:if test="${not empty idUtilisateur}">
		<h2>Bienvenue, ${pseudoUtilisateur}</h2>
		<a href="ServletVendreUnArticle">Vendre un article</a>
		<a href="ServletMonProfil">Mon profil</a>
		<a href="ServletDeconnexion">Déconnexion</a>
		
	

	<!-- CI-DESSOUS, AFFICHAGE UNE FOIS CONNECTE -->
	<form action="ServletAccueil" method="post">
		<div>
			<input type="radio" name="toggle" value="achats" checked>Achats
			<div id="achatsFilters">
				<input type="checkbox" name="enchères" id="enchèresCheckbox">
				<label for="enchèresCheckbox">Enchères</label>
				
				<input type="checkbox" name="mesEnchères" id="mesEnchèresCheckbox">
				<label for="mesEnchèresCheckbox">Mes enchères</label>
				
				<input type="checkbox" name="mesEnchèresRemportées" id="mesEnchèresRemportéesCheckbox"> 
				<label for="mesEnchèresRemportéesCheckbox">Mes enchères remportées</label>
			</div>
		</div>

		<input type="radio" name="toggle" value="ventes">Ventes
		<div id="ventesFilters">
			<input type="checkbox" name="mesVentesEnCours" id="enchèresCheckbox">
			<label for="mesVentesEnCoursCheckbox"> Mes ventes en cours</label>
			
			<input type="checkbox" name="mesVentesAVenir" id="mesVentesAVenirCheckbox">
			<label for="mesVentesAVenirCheckbox">Mes ventes à venir</label>
			
			<input type="checkbox" name="mesVentesTerminees"	id="mesVentesTermineesCheckbox"> 
			<label for="mesVentesTermineesCheckbox">Mes ventes terminées</label>
		</div>

		<input type="submit" value="Filtrer">

		<div id="ListeDesEncheres">
			<c:forEach items="${ListeEncheres}" var="article">
				<div class="article">
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
		</c:if>
		

		<%-- 	
		<div id="ventesFilters">
			<h3>Mes articles en vente actuellement</h3>
			<input type="checkbox" name="mesVentesEnCours"
				id="mesVentesEnCoursCheckbox"> <label
				for="mesVentesEnCoursCheckbox">Mes ventes en cours</label>
			<div id="ListeDeMesVentes">
				<c:forEach items="${mesArticlesEnVente}" var="article">
					<div class="article">
						<h2>
							<a href="ServletEncherir?id_Article=${article.id_Article}"
								data-id="${article.id_Article}">${article.nom_article}</a>
						</h2>
						<p>Date de début d'enchères : ${article.date_debut_encheres}</p>
						<p>Date de fin d'enchères : ${article.date_fin_encheres}</p>
						<p>Prix initial : ${article.mise_a_prix}</p>
						<p>Vendeur : ${article.utilisateur.pseudo}</p>
					</div>
				</c:forEach>
			</div>

			<h3>Mes ventes à venir</h3>
			<input type="checkbox" name="mesVentesAVenir"
				id="mesVentesAVenirCheckbox"> <label>
				for="mesVentesAVenirCheckbox">Mes ventes à venir</label>
			<div id="ListeDeMesVentesAVenir">
				<c:forEach items="${mesVentesAVenir}" var="article">
					<div class="article">
						<h2>
							<a href="ServletEncherir?id_Article=${article.id_Article}"
								data-id="${article.id_Article}">${article.nom_article}</a>
						</h2>
						<p>Date de début d'enchères : ${article.date_debut_encheres}</p>
						<p>Date de fin d'enchères : ${article.date_fin_encheres}</p>
						<p>Prix initial : ${article.mise_a_prix}</p>
						<p>Vendeur : ${article.utilisateur.pseudo}</p>
					</div>
				</c:forEach>
			</div>

			<h3>Mes ventes terminées</h3>
			<input type="checkbox" name="mesVentesTerminees"
				id="mesVentesTermineesCheckbox"> <label
				for="mesVentesTermineesCheckbox">Mes ventes terminées</label>
			<div id="ListeDeMesVentesTerminees">
				<c:forEach items="${mesVentesTerminees}" var="article">
					<div class="article">
						<h2>
							<a href="ServletEncherir?id_Article=${article.id_Article}"
								data-id="${article.id_Article}">${article.nom_article}</a>
						</h2>
						<p>Date de début d'enchères : ${article.date_debut_encheres}</p>
						<p>Date de fin d'enchères : ${article.date_fin_encheres}</p>
						<p>Prix initial : ${article.mise_a_prix}</p>
						<p>Vendeur : ${article.utilisateur.pseudo}</p>
					</div>
				</c:forEach>
			</div> --%>
		</div>
	</form>
</body>
</html>