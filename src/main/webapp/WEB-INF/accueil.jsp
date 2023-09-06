<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
	<h1>Liste des enchères</h1>
	
	<a href="ServletConnexion">S'inscrire - se connecter</a>
	<a href="ServletNouvelleVente">Vendre un article</a>
	<a href="ServletAccueil">Déconnexion</a>
	<a href="ServletMonProfil">Mon profil</a>

    <ul>
        <c:forEach items="${encheres}" var="enchere">
            <li>Date : ${enchere.date_enchere}, Montant : ${enchere.montant_enchere}</li>
        </c:forEach>
    </ul>
</body>
</html>