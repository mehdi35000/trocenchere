<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@picocss/pico@1/css/pico.min.css" />
<link rel="stylesheet" type="text/css" href="CSS/connexion.css">
</head>
<body>
	<main class="container">
		<article class="grid">
			<div>

				<h1>Inscription</h1>
				<section id="preview">
					<h2>Saisissez vos details</h2>

					<form action="ServletInscription" method="POST">

						<label for="pseudo"> Pseudo :</label> <input type="text"
							id="pseudo" name="pseudo"> <br> <label for="nom">Nom
							:</label> <input type="text" id="nom" name="nom"> <br> <label
							for="prenom">Prénom :</label> <input type="text" id="prenom"
							name="prenom"> <br> <label for="email">E-mail
							:</label> <input type="email" id="email" name="email"> <br>
						<label for="telephone">Téléphone :</label> <input type="tel"
							id="telephone" name="telephone"> <br> <label
							for="rue">Rue :</label> <input type="text" id="rue" name="rue">
						<br> <label for="codePostal">Code Postal :</label> <input
							type="text" id="codePostal" name="codePostal"> <br>
						<label for="ville"> Ville :</label> <input type="text" id="ville"
							name="ville"> <br> <label for="motDePasse">
							Mot de Passe :</label> <input type="password" id="motDePasse"
							name="motDePasse"> <br> <label for="confirmation">
							Confirmation :</label> <input type="password" id="confirmation"
							name="confirmation"> <br> <input type="submit"
							value="Créer"> <a href="ServletAccueil">Annuler</a>

					</form>
				</section>
			</div>
		</article>
	</main>
</body>
</html>