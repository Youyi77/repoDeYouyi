<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<html>
<head>
<title>Home</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/home.css" />


</head>
<body>
	<h1>Hello world!</h1>
	<form action="calculer" method="post">
		<table>
			<tr>
				<td>Nbr1</td>
				<td><input type="text" name="nbr1"></td>
			</tr>
			<tr>
				<td>Nbr2</td>
				<td><input type="text" name="nbr2"></td>
			</tr>
			<tr>
				<td><input type="submit" value="calculer"></td>
			</tr>
		</table>
	</form>
	
	<p>La somme de ${nbr1} et ${nbr2} donne ${monCalcul}</p>
	
	
	
	
	<form action="sauvegarder" method="post">
	<Table>
	<tr><td>Nom</td><td><input type="text" name="nomClient"/></td></tr>
	<tr><td>Prenom</td><td><input type="text" name="prenomClient"/></td></tr>
	<tr><td><input type ="submit" value="enregistrer"/></td></tr>
	
	</Table>
	</form>
	
	<form action="seeAll" method="post">
	<input type ="submit" value="VoirTout"/>
	<br>
	* clients : ${mClients}
	</form>

	<form action="get" method="get">
		<input type="submit" value="Se rendre page 2">
	</form>
	<form action="page3" method="get">
		<input type="submit" value="Aller sur les voitures">
	</form>
	<a href="voiture.jsp">Aller sur les voitures</a>
</body>
</html>
