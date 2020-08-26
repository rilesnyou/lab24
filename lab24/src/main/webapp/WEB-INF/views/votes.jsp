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
<a href="/review-page">Review Options</a>
<h1>Pizza Options</h1>
	<ol>
		<c:forEach var="partyOption" items="${partyOption}">
			<li><b>Name:</b>${partyOption.name} <b>Type:</b>${partyOption.description} <b>Votes:</b>${partyOption.votes}</li>
		</c:forEach>
	</ol>
	
	<h2>Add an option</h2>
	<p><label>Name: </label><input name="name" /></p>
	<p><label>Description: </label><input name="description" /></p>
	<button type="submit">Add</button>
</body>
</html>