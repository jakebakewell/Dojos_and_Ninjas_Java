<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body>
	<div class="container text-center">
		<h1>New Ninja</h1>
		<form:form action="/ninja/new" method="post" modelAttribute="ninja">
		    <p>
		        <form:label path="firstName">First Name</form:label>
		        <form:errors path="firstName"/>
		        <form:input path="firstName"/>
		    </p>
		    <p>
		        <form:label path="lastName">Last Name</form:label>
		        <form:errors path="lastName"/>
		        <form:input path="lastName"/>
		    </p>
		    <p>
		        <form:label path="age">Age</form:label>
		        <form:errors path="age"/>
		        <form:input type="number" path="age"/>
		    </p>
		    <p>
	            <form:select path = "dojo">
					<c:forEach items="${dojoList}" var="dojo">
						<form:option value="${dojo.id}">${dojo.name}</form:option>
					</c:forEach>
	            </form:select>
		    </p>
		    <input type="submit" value="Submit" class="btn btn-success mt-3"/>
		</form:form>
	</div>
</body>
</html>