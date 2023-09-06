<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>

<h1>Connexion</h1>
	<form action="ServletConnexion" method="POST">
	
	<label for="pseudo"> Identifiant :</label>
	<input type="text" id="pseudo" name="pseudo" >
	<br>
	
	<label for="motDePasse"> Mot de Passe :</label>
	<input type="password" id="motDePasse" name="motDePasse">
	<br>
	<input type="submit" value="Connexion">
	</form>	
	<label for="seSouvenir"> Se souvenir de moi :</label>
	<input type="checkbox" id="seSouvenir" name="seSouvenir">
	
	<a href="">Mot de passe oublié</a>
	<br>
	
	
	<a href="ServletInscription">Créer un compte</a>

</body>
</html>