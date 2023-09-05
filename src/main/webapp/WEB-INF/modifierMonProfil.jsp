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
	
	<form action="ServletAccueil" method="post">
	<div>
	<label for="pseudo">Pseudo :</label>
    <input type="text" name="pseudo" value="${utilisateur.pseudo}">
    </div>
    <div>
    <label for="prenom">Prénom :</label>
    <input type="text" name="prenom" value="${utilisateur.prenom}">
    </div>
    <div>
    <label for="nom">Nom :</label>
    <input type="text" name="nom" value="${utilisateur.nom}">
    </div>
    <div>
    <label for="email">Email :</label>
    <input type="text" name="email" value="${utilisateur.email }">
    </div>
    <div>
    <label for="telephone">Téléphone :</label>
    <input type="text" name="telephone" value="${utilisateur.telephone }">
    </div>
    <div>
    <label for="rue">Rue :</label>
    <input type="text" name="rue" value="${utilisateur.rue }">
    </div>
    <div>
    <label for="code_postal">Code postal :</label>
    <input type="text" name="code_postal" value="${utilisateur.codePostal }">
    </div>
    <div>
    <label for="ville">Ville :</label>
    <input type="text" name="ville" value="${utilisateur.ville }">
    </div>
    <div>
    <label for="mdpactuel">Mot de passe actuel :</label>
    <input type="text" name="mdpactuel" value="${utilisateur.mdp }">
    </div>
    <div>
    <label for="nv_mdp">Nouveau mot de passe :</label>
    <input type="text" name="nv_mdp" value="">
    </div>
    <div>
    <label for="conf_nv_mdp">Confirmation du mot de passe :</label>
    <input type="text" name="conf_nv_mdp" value="">
    </div>
    <div>
    <label for="credit">Crédit :</label>
    <input value="${credit }">
    </div>

		<input class="btn btn-primary mb-2" type="submit" value="enregistrer">
		<input class="btn btn-primary mb-2" type="submit" value="supprimer le profil">
	</form>
</body>
</html>