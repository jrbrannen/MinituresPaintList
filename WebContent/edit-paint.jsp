<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	
		<meta charset="ISO-8859-1">
		
		<title>Edit Paints</title>
		
		<link rel="stylesheet" type="text/css" href="mainStyle.css">
		
	</head>
	
	<body>
	
		<form action="editPaintServlet" method="post">
		
			Brand: <input type="text" name="BrandName" value="${paintToEdit.brand}">
			
			Color: <input type="text" name="ColorName" value="${paintToEdit.color}">
			
			Medium: <input type="text" name="Medium" value="${paintToEdit.medium}">
			
			<input type="hidden" name="id" value="${paintToEdit.id}">
			
			<input type="submit" value="Save Edited Item">
			
		</form>
		
	</body>
	
</html>