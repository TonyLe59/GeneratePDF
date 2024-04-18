<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Formulaire PDF</title>
<link rel='stylesheet' type='text/css' href='styles.css' />
</head>
<body>
	<h1>Veuillez remplir le formulaire</h1>

		<form method="post" action="login">
			<label for='txtNom'> Nom Produit : </label> 
			<input id='txtNom' name='txtNom' type='text' value='${nomProduit}'/> 
			<br />
			<label for='txtPrix'> Prix : </label>
			<input id='txtPrix' name='txtPrix' type='text' value='${prix}'/> 
			<br />
			<label for='txtQuantite'> Quantite : </label> 
			<input id='txtQuantite'name='txtQuantite' type='text' value='${quantite}'/> 
			<br />
			<br />
			<br /> 
			<button type="submit" name="action" value="calculer">Calculer TotalTTC</button>
		</form>
</body>
</html>