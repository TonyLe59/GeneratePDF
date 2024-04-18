<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Resultat</title>
<link rel='stylesheet' type='text/css' href='styles.css' />
</head>
<body>
	<h1>Veuillez remplir le formulaire</h1>

	<form method="post" action="GeneratePDF">
		<label for='txtNom'> Nom Produit : </label> 
		<input id='txtNom' name='txtNom' type='text' value='${nomProduit}' /> <br /> 
		<label for='txtPrix'> Prix : </label> 
		<input id='txtPrix' name='txtPrix' type='text' value='${prix}' /> <br /> 
		<label for='txtQuantite'> Quantite : </label> 
		<input id='txtQuantite' name='txtQuantite' type='text' value='${quantite}' /> <br /> 
		<label for='txtTotalTTC'> TotalTTC : </label> <label for='totalTTC'> <%=request.getAttribute("totalTTC")%></label>
		<br /> 
		<br /> 
		<input type='submit' value='Générer PDF'>
	</form>
</body>
</html>
