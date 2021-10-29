<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Show</title>
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
	</head>
	<body>
		<main>
		    <nav>
			    <a href="/dashboard">Dashboard</a>
			</nav>
			<h1>Title: <c:out value="${song.title}"></c:out></h1>
			<p>Artist: <c:out value="${song.artist}"></c:out></p>
			<p>Rating: <c:out value="${song.rating}"></c:out></p>
			<div class="div">
				<a href="/delete/${ song.id }">Delete</a>
			</div>
			
		</main>
	</body>
</html>