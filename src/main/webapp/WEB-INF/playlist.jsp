<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

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
				<h1><a href="/songs/new">Add New</a>  <a href="/songs/topTen">Top Ten</a></h1>
				<form class="searh" action="/search">
					<input type="text" name="artist"/>
					<button type="submit">
						Search Artist
					</button>
				</form>
			</nav>
			<h1>All Songs</h1>
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