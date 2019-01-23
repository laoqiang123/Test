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
<body style="text-align: center;">
	<table border="1px" cellpadding="8px" cellspacing="0"
		style="margin: 0 auto; border-color: blue">
		<thead>
			<th>photo</th>
			<th>name</th>
			<th>sex</th>
			<th>age</th>
			<th colspan="2">operation</th>
		</thead>
		<c:set var="p" scope="page" value="${p}" />
		<c:if test="${!empty users}">
			<c:forEach items="${users}" step="1" var="user">

				<tr>
					<td><img style="width: 30px; height: 30px"
						src="showphoto?uid=${user.uid}"></td>
					<td>${user.name}</td>
					<td>${user.sex}</td>
					<td>${user.age}</td>
					<td><a href="<c:url value="deleteUser?uid=${user.uid}"/>">delete</a></td>
					<td><a href="<c:url value="update?uid=${user.uid}"/>">update</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<c:choose>
		<c:when test="${p>0}">
			<a href="<c:url value="loadAllUser?page=${p-1}"/>">pre page</a>
		</c:when>
		<c:otherwise>
			<a href="" />none pre page</a>
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${p<max}">
			<a href="<c:url value="loadAllUser?page=${p+1}"/>">next page</a>
		</c:when>
		<c:otherwise>
			<a href="" />none next page</a>
		</c:otherwise>
	</c:choose>
</body>
</html>