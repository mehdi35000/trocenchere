<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>

	<h1>Liste des enchères</h1>
<!-- rajout du core, et menu conditionnel -->
<c:if test="${empty idUtilisateur}">
	<a href="ServletConnexion">S'inscrire - se connecter</a>
</c:if>

<c:if test="${not empty idUtilisateur}">
	<a href="ServletNouvelleVente">Vendre un article</a>
	<a href="ServletMonProfil">Mon profil</a>
	<a href="ServletAccueil">Déconnexion</a>
	
	<h2>Bienvenue, <%= request.getParameter("utilisateur") %></h2>
</c:if>

    <ul>
        <c:forEach items="${encheres}" var="enchere">
            <li>Date : ${enchere.date_enchere}, Montant : ${enchere.montant_enchere}</li>
        </c:forEach>
    </ul>
</body>
</html>