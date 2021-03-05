<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	
		<meta charset="ISO-8859-1">
		
		<title>Edit A Painter</title>
		
		<link rel="stylesheet" type="text/css" href="mainStyle.css">
		
	</head>
	
	<body>
		
		<form action="editPainterServlet" method="post">
		
			Painter's Name: <input type="text" name="name" value="${painterToEdit.name}"><br />
			
			Painter's Age:	<input type="text" name="age" value="${painterToEdit.age}"><br />
			
			Painter's Technique:	<input type="text" name="technique" value="${painterToEdit.technique}"><br />
			
			<input type="hidden" name="id" value="${painterToEdit.id }">	
					
			Available Paints:<br />
			
				<select name="allPaintsToAdd" multiple size="12">
				
					<c:forEach items="${requestScope.allPaints}" var="currentPaints">
						<option value ="${currentpaint.id}">${currentpaint.brand} | ${currentpaint.color} | ${currentpaint.medium}</option>
					</c:forEach>
					
				</select>
				<br/>
				
				<input type="submit" value="Edit Painter and Add paints">
		</form>	
		
		<a href="index.html">Go add new paint instead.</a>
		
	</body>
	
</html>