<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
<h1>Inscription</h1>
	<form action="ServletInscription" method="POST">

	<label for="pseudo"> Pseudo :</label>
	<input type="text" id="pseudo" name="pseudo" >
	<br>
	
	<label for="nom">Nom :</label>
	<input type="text" id="nom" name="nom">
	<br>
	
	<label for="prenom">Prénom :</label>
	<input type="text" id="prenom" name="prenom">
	<br>
	
	<label for="email">E-mail :</label>
	<input type="email" id="email" name="email">
	<br>
	
	<label for="telephone">Téléphone :</label>
	<input type="tel" id="telephone" name="telephone">
	<br>
	
	<label for="rue">Rue :</label>
	<input type="text" id="rue" name="rue">
	<br>
	
	<label for="codePostal">Code Postal :</label>
	<input type="text" id="codePostal" name="codePostal">
	<br>
	
	<label for="ville"> Ville :</label>
	<input type="text" id="ville" name="ville">
	<br>
	
	<label for="motDePasse"> Mot de Passe :</label>
	<input type="password" id="motDePasse" name="motDePasse">
	<br>
	
	<label for="confirmation"> Confirmation :</label>
	<input type="password" id="confirmation" name="confirmation">
	<br>
	
	<input type="submit" value="Créer">
	<a href="ServletAccueil">Annuler</a>
	</form>	
	
</body>
</html>