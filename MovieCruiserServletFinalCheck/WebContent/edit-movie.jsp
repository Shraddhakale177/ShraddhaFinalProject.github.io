<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<title>Edit Movie List</title>
<script src="js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/moviecruiser_logo.png"> <a href="ShowMovieListAdmin">Movies</a>
	</div>
	<h3>Edit Movie</h3>

	<div class="body-content-color">
		<form action="EditMovie" onsubmit="return validateForm()"
			name="editMovie" method="post">
			<br>
			<div class="form">
				<label for="Title">Title</label> <br> <input type="text"
					class="text-box text-box-title" name="title" id="name"
					value="${movies.title}">
			</div>
			<br>

			<div class="form-field-spacing">
				<label for="gross">Gross($)</label> <br> <input type="text"
					class="text-box" name="gross" id="gross" value="${movies.gross}">
			</div>

			<div class="form-field-spacing">

				<label for="active">Active</label> <br> <input
					class="radio" type="radio" name="active" value="yes"
					<c:if test="${movies.active}">checked</c:if>>Yes <input
					class="radio" type="radio" name="active" value="no"
					<c:if test="${!movies.active}">checked</c:if>>No
			</div>
			<div class="form-field-spacing">
				<label for="Date of Launch">Date of Launch</label> <br> <input
					type="text" class="text-box" name="dateOfLaunch"
					value="<fmt:formatDate value="${movies.dateOfLaunch }"
						 pattern="dd/MM/yyyy" />">
			</div>
			<div class="form-field-spacing">
				<label for="genre">Genre</label> <br> <select name="genre"
					class="dropdown">
					<option value="${movies.genre}">${movies.genre}</option>
					<option value="0">Genre</option>
					<option value="Science Fiction">Science Fiction</option>
					<option value="Superhero">Superhero</option>
					<option value="Romance">Romance</option>
					<option value="Comedy">Comedy</option>
					<option value="Adventure">Adventure</option>
					<option value="Thriller">Thriller</option>
				</select>
			</div>
			<div class="form-field-spacing">
				<label for="teaser">Has Teaser</label> <input type="checkbox"
					name="teaser" <c:if test="${movies.teaser}">checked</c:if> />
			</div>
			<br>
			<div>
				<input type="hidden" name="id" value="${movies.id}">
			</div>
			<br>
			<div class="form-field-spacing">
				<input type="submit" class="button success-button" value="save">
			</div>
		</form>
	</div>
	<div class="footer">
		<h3>Copyright © 2019</h3>
	</div>
</body>
</html>