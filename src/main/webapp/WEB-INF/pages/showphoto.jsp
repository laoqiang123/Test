<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*"%>
<%@page import="javax.imageio.*"%>
<%@page import="java.awt.image.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	response.setContentType("image/jpg"); 
    OutputStream outs = response.getOutputStream(); 
    byte[] b = request.getParameter("image").getBytes();
    InputStream in =new ByteArrayInputStream(b);
    BufferedImage bi = null;
    bi = ImageIO.read(in);
    ImageIO.write(bi, "jpg",outs);
    outs.flush();
    outs.close();
%>

<body>
</html>