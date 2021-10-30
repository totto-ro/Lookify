<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TopTen</title>
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
	</head>
	<body>
		<main>
		    <nav>
		    	<h1>Top Ten Songs:</h1>
			    <a href="/dashboard">Dashboard</a>
			</nav>
			<div class="div">
				<c:forEach var="element" items="${songTop}">
				<ul>
					<li>
					<h2 class="topten">${ element.rating } - <a href="/songs/${ element.id }">${ element.title }</a> - ${ element.artist}</h2>
					</li>
				</ul>
				</c:forEach>
			</div>
		</main>
	</body>
</html>