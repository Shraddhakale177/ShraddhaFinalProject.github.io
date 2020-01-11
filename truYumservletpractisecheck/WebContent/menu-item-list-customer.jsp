<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles/style.css">
<title>Edit Menu Item</title>
<script src="js/script.js"></script>
<title></title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truYum_logo.png"> <a href="ShowCart">Cart</a> <a
			href="ShowMenuItemListCustomer">Menu</a>
	</div>

	<div class="page-title">MenuItem</div>
	<c:if test="${addCartStatus}">
		<div class="success-message">Items added to Cart Successfully.</div>
	</c:if>
	<table>
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th class="currency">Price</th>
			<th>Category</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${menuItemList}" var="menuItem">
			<tr>
				<td>${menuItem.name}</td>
				<td><c:if test="${menuItem.freeDelivery}">Yes</c:if> <c:if
						test="${!menuItem.freeDelivery}">No</c:if></td>
				<td class="currency">Rs<fmt:formatNumber
						value="${menuItem.price}" pattern="#,##,##,##,###.00" /></td>
				<td>${menuItem.category}</td>
				<td><a href="AddToCart?id=${menuItem.id}">Add to cart</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>




