<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css" />
<link rel="stylesheet" type="text/css" href="CSS/connexion.css">
<title>Connexion</title>
</head>
<body>
	<main class="container">
		<article class="grid">
			<div>
				<hgroup>
					<h1>Connexion</h1>
					<h2>Saississez votre Pseudo et votre mot de passe</h2>
				</hgroup>

				<form action="ServletConnexion" method="POST">

					<label for="pseudo"> Identifiant :</label> <input type="text"
						id="pseudo" name="pseudo"> <br> <label
						for="motDePasse"> Mot de Passe :</label> <input type="password"
						id="motDePasse" name="motDePasse"> <br> <input
						type="submit" value="Connexion"> <label for="seSouvenir">
					</label> <input type="checkbox" role="switch" id="seSouvenir"
						name="seSouvenir" /> Se souvenir de moi <br> <a href="">Mot
						de passe oublié</a> <br> <a href="ServletInscription">Créer
						un compte</a> <br>
				</form>
			</div>
		</article>
	</main>
</body>
</html>