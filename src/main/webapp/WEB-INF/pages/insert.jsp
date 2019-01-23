<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="user" enctype="multipart/form-data"
		method="post" action="insert">
		<table>
		<tr>
		<td><form:label path="name">username:</form:label></td>
		<td><form:input path="name"></form:input></td>
		</tr>
		<br>
		<tr>
		<td><form:label path="sex">sex:</form:label></td>
		<td><form:radiobutton path="sex" value="M" label="Male" />
		<form:radiobutton path="sex" value="F" label="Female" /></td>
		</tr>
		<br>
		<tr>
		<td><form:label path="age">age:</form:label></td>
		<td><form:input path="age"></form:input></td>
		</tr>
		<br>
		<tr>
		<td>
		<form:label path="image">image:</form:label>
		</td>
		<td><input type="file" name="image1"   accept="image/jpeg,image/png,image/gif"/></td>
		</tr>
		<tr>
		<td colspan="2" style="   text-align: center;">
		<input type="submit" text="submit" />
		</td>
		</tr>
		</table>
	</form:form>
</body>
</html>