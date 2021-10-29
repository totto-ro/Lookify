<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Add new song</title>
		<link rel="stylesheet" type="text/css" href="./CSS/edit.css">
	</head>
	<body>
		<main>
			<nav>
			    <form action="/${language.id}" method="POST">
				    <input type="hidden" name="_method" value="delete">
				    <input type="submit" value="delete">
			    </form>
			    <a href="/dashboard">Dashboard</a>
			</nav>
			<div>
				<form:form action="/songs/new" method="post" modelAttribute="language">
			    <p>
			        <form:label path="title">Title</form:label>
			        <form:errors path="title"/>
			        <form:input path="title"/>
			    </p>
			    <p>
			        <form:label path="artist">Artist</form:label>
			        <form:errors path="artist"/>
			        <form:input path="artist"/>
			    </p>
			    <p>
			        <form:label path="rating">Rating</form:label>
			        <form:errors path="rating"/>
			        <form:input type="number" path="rating"/>
			    </p>   
			    <input class="bSummit" type="submit" value="Submit"/>
			</form:form>    
			</div>
		</main>
	
	</body>
</html>