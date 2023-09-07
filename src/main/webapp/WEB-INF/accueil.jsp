<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>

<style>
  .article {
    border: 1px solid #ccc; /* Bordure autour de chaque article */
    padding: 10px; /* Espace intérieur pour le contenu de l'article */
    margin-bottom: 20px; /* Marge inférieure pour séparer les articles */
  }
</style>
</head>
<body>

	<h1>Liste des enchères</h1>
<!-- rajout du core, et menu conditionnel -->

    <c:forEach items="${articlesEnVente}" var="article">
    	<div class="article">
            <h2>${article.nom_article}</h2>
            <p>Date de début d'enchères : ${article.date_debut_encheres}</p>
            <p>Date de fin d'enchères : ${article.date_fin_encheres}</p>
            <p>Prix initial : ${article.mise_a_prix}</p>
            <p>Vendeur : ${article.utilisateur.pseudo}</p>
        </div>
    </c:forEach> 

<c:if test="${empty idUtilisateur}">
	<a href="ServletConnexion">S'inscrire - se connecter</a>
</c:if>

<c:if test="${not empty idUtilisateur}">
	<a href="ServletNouvelleVente">Vendre un article</a>
	<a href="ServletMonProfil">Mon profil</a>
	<a href="ServletAccueil">Déconnexion</a>
	
    <h2>Bienvenue, ${idUtilisateur}</h2>
</c:if>


</body>
</html>