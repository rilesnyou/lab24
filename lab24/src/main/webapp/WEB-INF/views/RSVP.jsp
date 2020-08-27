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
	<p>Navigation</p>
	<a href="/votes-page">Options & Votes</a>
	<a href="/review-page">Review Options</a>
	<a href="/">Home page</a>

	<h1>Party ${party.name}</h1>
	<p>${party.date}</p>
	<br>
	<h2>RSVP</h2>
	<table class="table">
		<thead>
			<tr>
				<th>Attendee</th>
				<th>Comment</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="rsvp" items="${party.rsvps}">
				<tr>
					<td>${rsvp.attendee}</td>
					<td>${rsvp.comment}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>