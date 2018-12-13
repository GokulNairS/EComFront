<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="Navbar.jsp"></c:import>
	<div style="min-height: 500px;">
		<c:if test="${sliderpage}">
			<c:import url="Slider.jsp"></c:import>
		</c:if>
		<c:if test="${aboutpage}">
			<c:import url="aboutus.jsp"></c:import>
		</c:if>
		<c:if test="${contactpage}">
			<c:import url="contact.jsp"></c:import>
		</c:if>
		<c:if test="${categorypage}">
			<c:import url="category.jsp"></c:import>
		</c:if>
		<c:if test="${productpage}">
			<c:import url="Product.jsp"></c:import>
		</c:if>
		<c:if test="${registerpage}">
			<c:import url="register.jsp"></c:import>
		</c:if>
	</div>
</body>
</html>