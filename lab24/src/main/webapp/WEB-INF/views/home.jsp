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

<p>Navigation</p><a href="/votes-page">Options & Votes</a>
<a href="/review-page">Review Options</a>
<h1>Parties</h1>

	<ol>
		<c:forEach var="party" items="${party}">
			<li><b>Type:</b> ${party.name} <b>Date:</b> ${party.date}</li>
		</c:forEach>
	</ol>
</body>
</html>