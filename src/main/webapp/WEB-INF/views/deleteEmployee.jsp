<%@page import="com.capgemini.springmvc.beans.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page session="false" %>
<%String msg = (String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./deleteEmployee" method="post">
		<table>
			<tr>
				<td>Emp ID</td>
				<td> : </td>
				<td><input type="number" name="empId" required></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<br /><input type="submit" value="Delete Employee">
				</td>
			</tr>
		</table>
	</form>
	<br><br>
	<%if(msg != null && !msg.isEmpty()) { %>
		<%=msg %>
	<%} %>
</body>
</html>
