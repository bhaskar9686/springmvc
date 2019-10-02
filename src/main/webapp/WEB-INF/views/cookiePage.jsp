<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page session="false" %>
    <%String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cookie Using Spring MVC</title>
</head>
<body>
<%if (msg != null && !msg.isEmpty()) { %>
		<h1><%=msg%></h1>
	<%} %>
	<br/><br/>
	
	<a href="./createCookie">Click here</a> to Create Cookie.
	<br /><br />
	<a href="./readCookie">Click here</a> to see cookie value.

</body>
</html>