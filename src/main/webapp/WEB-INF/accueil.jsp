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

<table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Date</th>
                <th>Montant</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${encheres}" var="enchere">
                <tr>
                    <td>${enchere.id}</td>
                    <td>${enchere.date_enchere}</td>
                    <td>${enchere.montant_enchere}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>