<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vendre un article</title>
</head>
<body>
	<h1>ENI-Enchères</h1>
	<h1>Nouvelle vente</h1>

	<form action="" method="post">
		<ul>
			<li><label for="article">Article :</label> <input type="text"
				id="article" name="article" /></li>
			<li><label for="description">Description :</label> <textarea
					id="description" name="description"></textarea></li>
			<li><label for="Categorie">Categorie :</label> <select
				name="categorie" id="categorie">
					<option value="">--Choississez une catégorie--</option>
					<option value="1">Ameublement</option>
					<option value="2">Informatique</option>
					<option value="3">Vêtements</option>
					<option value="4">Sport et loisirs</option>
			</select></li>
			<li><a href="">Photo de l'article : <input type="button"
					value="uploader" /></a></li>
			<li>Mise à prix : <input type="number" id="miseAprix"
				name="miseAprix" min="1" max="100000" />
			</li>
			<li>Début de l'enchère : <input id="dateDebut" name="dateDebut"
				type="date" value="${dateDebut}" readonly />
			</li>
			<li>Fin de l'enchère : <input id="dateFin" name="dateFin"
				type="date" value="" />
			</li>
		</ul>
		<h2>Retrait</h2>
		<p>Rue :</p>
		<p>Code postal :</p>
		<p>Ville :</p>
		<a href="ServletAccueil"><input type="submit" value="Enregistrer" /></a>
		<a href="ServletAccueil"><input type="reset" value="Annuler" /></a>
	</form>




</body>
</html>