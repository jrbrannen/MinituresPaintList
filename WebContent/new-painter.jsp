<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	
		<meta charset="ISO-8859-1">
		
		<title>Add A New Painter</title>
		
		<link rel="stylesheet" type="text/css" href="mainStyle.css">
		
	</head>
	
	<body>
	
		<form action="createNewPainterServlet" method="post">
		
			Painter's Name: <input type="text" name="name"><br />
			
			Painter's Age:	<input type="text" name="age"><br />
			
			Painter's Technique: <input type="text" name="technique"><br />
			
			Available Paints:<br />
			
				<select name="allPaintsToAdd" multiple size="12">
				
					<c:forEach items="${requestScope.allPaints}" var="currentPaints">
						<option value ="${currentpaint.id}">${currentpaint.brand} | ${currentpaint.color} | ${currentpaint.medium}</option>
					</c:forEach>
					
				</select>
			<br />
			<input type="submit" value="Add New Painter and Paints">
		</form>
		
		<a href="index.html">Go To Adding Paints</a>
	
	</body>
	
</html>