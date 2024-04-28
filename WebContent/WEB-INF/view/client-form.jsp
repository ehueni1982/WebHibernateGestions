<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un client</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>


	<div id="wrapper">
			<div id="header">
				<h2>Gestion client</h2>
			</div>
		</div>
		
		<div id="container">
		<h3>Sauvegarder client</h3>
		
	<form:form action="saveClient" modelAttribute="client" method="POST">
	<form:hidden path="id"/>
	
		<table>
				<tbody>
					<tr>
						<td><label>Prénom</label></td>	
						<td><label><form:input path="prenom"/></label></td>		
					</tr>	
					
					<tr>
						<td><label>Nom</label></td>	
						<td><label><form:input path="nom"/></label></td>		
					</tr>	
					
					<tr>
						<td><label>Email</label></td>	
						<td><label><form:input path="email"/></label></td>		
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save"></td>
					</tr>	
					
				</tbody>			
			</table>		
	</form:form>
			
	</div>

	<div style="clear; both;">
		<a href="${pageContext.request.contextPath}/client/list">Retour à la liste</a>
	</div>

</body>
</html>