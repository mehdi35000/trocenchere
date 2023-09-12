<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifier mon profil</title>
</head>
<body>

	<h1>Modifier mon profil</h1>
	
	<form action="ServletModifierMonProfil" method="post">
	<div>
		<label for="pseudo">Pseudo :</label>
    	<input type="text" name="pseudo" value="${utilisateurEnCours.pseudo}">
    </div>
    <div>
       <label for="nom">Nom :</label>
    	<input type="text" name="nom" value="${utilisateurEnCours.nom}">
    </div>
    <div>
    	<label for="prenom">Prénom :</label>
    	<input type="text" name="prenom" value="${utilisateurEnCours.prenom}">
    </div>
    <div>
    	<label for="email">Email :</label>
    	<input type="text" name="email" value="${utilisateurEnCours.email }">
    </div>
    <div>
    	<label for="telephone">Téléphone :</label>
    	<input type="text" name="telephone" value="${utilisateurEnCours.telephone }">
    </div>
    <div>
    	<label for="rue">Rue :</label>
    	<input type="text" name="rue" value="${utilisateurEnCours.rue }">
    </div>
    <div>
    	<label for="code_postal">Code postal :</label>
    	<input type="text" name="code_postal" value="${utilisateurEnCours.code_postal }">
    </div>
    <div>
    	<label for="ville">Ville :</label>
    	<input type="text" name="ville" value="${utilisateurEnCours.ville }">
    </div>
    <div>
    	Crédit : ${utilisateurEnCours.credit}
    </div>

<div>
		<input class="btn btn-primary mb-2" type="submit" value="Enregistrer les modifications">
		<input class="btn btn-primary mb-2" type="submit" value="Supprimer le profil">
</div>
	</form>
</body>
</html>