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
	
	<form action="/ma-page-de-traitement" method="post">
  <ul>
    <li>
      <label for="article">Article :</label>
      <input type="text" id="article" name="article" />
    </li>
    <li>
      <label for="description">Description :</label>
      <textarea id="description" name="description"></textarea>
      
    </li>
  </ul>
</form>

</body>
</html>