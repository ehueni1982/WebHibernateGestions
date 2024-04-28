<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Clients</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Gestion Hibernate</h2>		
		</div>		
	</div>
	<input type="button" value="Ajouter client" onclick="window.location.href='afficherformAjouter'; return false;" />

	<div>
		<div>
			<table>
				<tr>
					<th>Prenom</th>
					<th>Nom</th>
					<th>Email</th>
					<th>Action</th>
					<th></th>
					
				</tr>

				<c:forEach var="dataClients" items="${clients}">	
				<!-- Url contient updatelink qui va servir pour notre modification -->
				<c:url var="updateLink" value="/client/afficherFormModifier">
					<c:param name="clientId" value="${dataClients.id }"></c:param>
				</c:url>
				
				<!-- Url contient deletelink qui va servir pour supprimer un client -->
				<c:url var="deleteLink" value="/client/suppression">
					<c:param name="clientId" value="${dataClients.id }"></c:param>
				</c:url>
				
					<tr>
						<td>${dataClients.prenom}</td>
						<td>${dataClients.nom}</td>
						<td>${dataClients.email}</td>
						<td>
							<a href="${updateLink }">Modification</a>
						</td>
						<td>
							<a href="${deleteLink }">Suppression</a>
						</td>
					</tr>				
			  </c:forEach>			  
			</table>
		</div>	
	</div>	
</body>
</html>