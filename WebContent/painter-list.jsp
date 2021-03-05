<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		
		<title>List of Painters</title>
		
		<link rel="stylesheet" type="text/css" href="mainStyle.css">
		
	</head>
	
	<body>
		<form method="post" action="painterNavServlet">
		
			<table>
				
				<c:forEach items="${requestScope.allPainters}" var="currentitem">
				
					<tr>
						<td><input type="radio" name="id" value="${currentitem.id}"></td>
						<td>${currentitem.name}</td>
						<td>${currentitem.age}</td>
						<td>${currentitem.technique}</td>
					</tr>
					
				</c:forEach>
				
			</table>
			
			<input type="submit" value="edit a painter" name="doThisToPainter">
			
			<input type="submit" value="delete a painter" name="doThisToPainter">
			
			<input type="submit" value="add a painter" name="doThisToPainter">
	
		</form>
		
		<a href="index.html">Go back to add a paint</a>
	
	</body>
	
</html>