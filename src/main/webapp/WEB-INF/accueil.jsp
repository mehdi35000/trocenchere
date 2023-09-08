<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
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


<c:if test="${empty idUtilisateur}">
	<a href="ServletConnexion">S'inscrire - se connecter</a>
</c:if>

<c:if test="${not empty idUtilisateur}">
    <h2>Bienvenue, ${idUtilisateur}</h2>
	<a href="ServletVendreUnArticle">Vendre un article</a>
	<a href="ServletMonProfil">Mon profil</a>
	<a href="ServletDeconnexion">Déconnexion</a>
</c:if>
	

    <h3>Liste des enchères</h3>

    <c:forEach items="${articlesEnVente}" var="article">
    	<div class="article">
            <h2>${article.nom_article}</h2>
            <p>Date de début d'enchères : ${article.date_debut_encheres}</p>
            <p>Date de fin d'enchères : ${article.date_fin_encheres}</p>
            <p>Prix initial : ${article.mise_a_prix}</p>
            <p>Vendeur : ${article.utilisateur.pseudo}</p>
        </div>
    </c:forEach> 



</body>
</html>