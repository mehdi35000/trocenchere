<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css">
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
    </c:if>

    <c:if test="${not empty idUtilisateur}">
        <h2>Bienvenue, ${pseudoUtilisateur}</h2>
        <a href="ServletVendreUnArticle">Vendre un article</a>
        <a href="ServletMonProfil">Mon profil</a>
        <a href="ServletDeconnexion">Déconnexion</a>
    </c:if>


    <h3>Liste des enchères</h3>

    <c:forEach items="${articlesEnVente}" var="article" begin="0">
        <div class="article">
         <h2><a href="ServletEncherir?id_Article=${article.id_Article}" data-id="${article.id_Article}">${article.nom_article}</a></h2>
           <%--  <h2> <a href ="ServletEncherir"> ${article.nom_article}</a></h2> --%>
            <p>Date de début d'enchères : ${article.date_debut_encheres}</p>
            <p>Date de fin d'enchères : ${article.date_fin_encheres}</p>
            <p>Prix initial : ${article.mise_a_prix}</p>
            <p>Vendeur : ${article.utilisateur.pseudo}</p>
        </div>
    </c:forEach>


</body>
</html>