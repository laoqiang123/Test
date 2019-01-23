<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="user" enctype="multipart/form-data"
		method="post" action="updateUser">
		<table>
			<tr>
				<td><form:label path="name">username:</form:label></td>
				<td><form:input path="name" value="${updateuser.name}"></form:input></td>
			</tr>
			<br>
			<tr>
				<td><form:label path="sex">sex:</form:label></td>
				<c:out value="${updateuser.sex}" />
				<c:choose>
					<c:when test="${updateuser.sex eq 'M'}">
						<td><form:radiobutton path="sex" value="M" label="Male"
								checked="true" />
					</c:when>
					<c:otherwise>
						<td><form:radiobutton path="sex" value="M" label="Male" />
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${updateuser.sex eq 'F'}">
						<form:radiobutton path="sex" value="F" label="Female"
							checked="true" />
						</td>

					</c:when>
					<c:otherwise>
						<form:radiobutton path="sex" value="F" label="Female" />
						</td>
					</c:otherwise>
				</c:choose>
			</tr>
			<br>
			<tr>
				<td><form:label path="age">age:</form:label></td>
				<td><form:input path="age" value="${updateuser.age}"></form:input></td>
			</tr>
			<br>
			<tr>
				<td><form:label path="image">image:</form:label></td>
				<td><img style="width: 30px; height: 30px" src="showphoto?uid=${updateuser.uid}"/></td>
				<td><input type="file" name="image2"
					accept="image/jpeg,image/png,image/gif" /></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input
					type="submit" text="update" /></td>
				<td><form:hidden path="uid" value="${updateuser.uid}" /></td>
			</tr>

		</table>
	</form:form>
</body>
</html>