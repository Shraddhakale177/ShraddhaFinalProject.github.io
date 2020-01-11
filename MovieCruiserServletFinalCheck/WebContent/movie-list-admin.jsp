<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<title>Insert title here</title>
<script src="js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/moviecruiser_logo.png"> <a href="ShowMovieListAdmin">Movies</a>
	</div>

	<div class="field-spacing">
		<h1 class="message">Movies</h1>
		<table id="myTable">
			<tr>
				<th>Title</th>
				<th class="currency">Box Office</th>
				<th>Active</th>
				<th>Date of Launch</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${movieList}" var="movies">
				<tr>
				<td>${movies.title }</td>
					<td class="currency">$<fmt:formatNumber
							value="${movies.gross}" pattern="#,##,##,##,###" /></td>
					<td><c:if test="${movies.active}">Yes</c:if> <c:if
							test="${!movies.active}">No</c:if></td>
					<td><fmt:formatDate value="${movies.dateOfLaunch}"
							pattern="dd/MM/yyyy" /></td>
					<td>${movies.genre}</td>
					<td><c:if test="${movies.teaser}">Yes</c:if> <c:if
							test="${!movies.teaser}">No</c:if></td>
					<td><a href="ShowEditMovie?id=${movies.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="footer">
		<h3>Copyright @ 2019</h3>
	</div>
</body>
</html>
