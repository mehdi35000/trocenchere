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
	
	<form action="votre_servlet" method="post">
	
	<label for="pseudo">Pseudo :</label>
    <input type="text" name="pseudo" value="${utilisateur.pseudo}">
    
    <label for="prenom">Prénom :</label>
    <input type="text" name="prenom" value="${utilisateur.prenom}">
    
    <label for="nom">Nom :</label>
    <input type="text" name="nom" value="${utilisateur.nom}">
    
    <label for="email">Email :</label>
    <input type="text" name="email" value="${utilisateur.email }">
    
    <label for="telephone">Téléphone :</label>
    <input type="text" name="telephone" value="${utilisateur.telephone }">
    
    <label for="rue">Rue :</label>
    <input type="text" name="rue" value="${utilisateur.rue }">
    
    <label for="code_postal">Code postal :</label>
    <input type="text" name="code_postal" value="${utilisateur.codePostal }">
    
    <label for="ville">Ville :</label>
    <input type="text" name="ville" value="${utilisateur.ville }">
    
    <label for="mdpactuel">Mot de passe actuel :</label>
    <input type="text" name="mdpactuel" value="${utilisateur.mdp }">
    
    <label for="nv_mdp">Nouveau mot de passe :</label>
    <input type="text" name="nv_mdp" value="">
    
    <label for="conf_nv_mdp">Confirmation du mot de passe :</label>
    <input type="text" name="conf_nv_mdp" value="">
    
    <label for="credit">Crédit :</label>
    <input value="${credit }">
    
		<input class="btn btn-primary mb-2" type="submit" value="enregistrer">
		<input class="btn btn-primary mb-2" type="submit" value="supprimer le profil">
	</form>
</body>
</html>