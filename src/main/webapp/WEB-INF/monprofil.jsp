<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon Profil</title>
</head>
<body>

<h1>Mon profil</h1>

<h2>Voici votre profil ${pseudoUtilisateur} !</h2>

<p>Pseudo : ${utilisateurEnCours.pseudo }</p>
<p>Nom: ${utilisateurEnCours.nom}</p>
<p>Prenom: ${utilisateurEnCours.prenom}</p>
<p>Email: ${utilisateurEnCours.email}</p>
<p>Telephone : ${utilisateurEnCours.telephone}</p>
<p>Adresse : ${utilisateurEnCours.rue}</p>
<p>Code postal : ${utilisateurEnCours.code_postal}</p>
<p>Ville: ${utilisateurEnCours.ville}</p>

<a href="ServletModifierMonProfil"> Modifier mon profil </a>
</div>


<div>
<a href="ServletAccueil">Revenir à l'accueil</a>
</div>

</body>
</html>