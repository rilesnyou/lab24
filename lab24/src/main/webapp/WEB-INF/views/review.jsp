<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<p>Navigation</p><a href="/">Parties</a>
<a href="/votes-page">Options & Votes</a>

<h1>Pizza Options</h1>

	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Description</th>
				<th>Votes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="partyoption" items="${partyoption}">
				<tr>
					<td>${partyoption.name}</td>
					<td>${partyoption.description}</td>
					<td>${partyoption.votes}</td>
				</tr>
			</c:forEach>
		
		</tbody>
	
	</table>
</body>
</html>