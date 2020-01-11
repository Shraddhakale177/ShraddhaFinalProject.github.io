<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<title>Edit Menu Item</title>
<script src="js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truYum_logo.png"> <a href="ShowMenuItemListCustomer">Menu</a>
		<a href="ShowCart">Cart</a>
	</div>
	<div class="field-spacing">
		<h1 class="message">Cart</h1>
		<h3>
			No items in cart.Use 'Add to cart' option in <span><a
				href=ShowMenuItemListCustomer>Menu Item List</a></span>
		</h3>
	</div>
	<div class="footer">
		<h3>Copyright © 2019</h3>
	</div>
</body>
</html>