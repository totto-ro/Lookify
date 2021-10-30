<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dashboard</title>
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
	</head>
	<body>
		<main>
			<nav>
				<h1>Searched for: ${ artist }</h1>
				<form class="searh" action="/search">
					<input type="text" name="artist"/>
					<button type="submit">
						Search Artist
					</button>
				</form>
				<a href="/dashboard">Dashboard</a>
			</nav>
			<h1>All Songs</h1>
			<div>
				<h1>
					<c:out value="${message}"></c:out>
				</h1>
			</div>
			<table>
			    <thead>
			        <tr>
			            <th>Title</th>
			            <th>Rating</th>
			            <th>Actions</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach var="element" items="${songList}">
			        <tr>
			            <td><a href="/songs/${ element.id }">${ element.getTitle() }</a></td>
			            <td><c:out value="${element.getRating()}"/></td>
			            <td class="actions">
				            <form action="/delete/${element.getId()}" method="POST">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="delete">
							</form>
			            </td>
			        </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</main>
	</body>
</html>