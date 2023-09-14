<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="CSS/commun.css">
<title>Vendre un article</title>
</head>
<body>
<main class="container" style="display: flex; justify-content: center; align-items: center">
		<article class="grid">

		<form action="ServletVendreUnArticle" method="POST">
	<h2>Nouvelle vente</h2>
	

	
			<label for="article"> Article :</label>
			<input type="text" id="article" name="article" />
			<br>
			<br>
			
			<label for="description">Description :</label> <textarea
					id="description" name="description"></textarea>
			<br>
			<br>
			
			<div class="col-md-6">
			<label for="Categorie">Categorie :</label> <select
				name="categorie" id="categorie">
					<option value="">--Choississez une catégorie--</option>
					<option value="1">Ameublement</option>
					<option value="2">Informatique</option>
					<option value="3">Vêtements</option>
					<option value="4">Sport et loisirs</option>
			</select>
			</div>
			<br>
			<br>
			<div class="col-md-6">
			<a href="">Photo de l'article : <input type="button"
					value="uploader" /></a>
			</div>
			<br>
			<br>
			
			<div class="col-md-6">
			Mise à prix : <input type="number" id="miseAprix"
				name="miseAprix" min="1" max="100000" />
			</div>
			<br>
			<br>

			Début de l'enchère : <input id="dateDebut" name="dateDebut"
				type="date" value="${currentDate}" min="${currentDate}" />

			Fin de l'enchère : <input id="dateFin" name="dateFin"
				type="date" value="${currentDate}" min="${currentDate}" />
	<hr>
		<h2>Retrait</h2>
		<p>Rue : <input type="text"
				id="rue" name="rue" /></p>
		<p>Code postal : <input type="text"
				id="codePostal" name="code_postal" /></p>
		<p>Ville : <input type="text"
				id="ville" name="ville" /></p>
		<a href="ServletAccueil"><input type="submit" value="Enregistrer" /></a>
		<a href="ServletAccueil"><input type="reset" value="Annuler" /></a>
	</form>


</article>
</main>

</body>
</html>