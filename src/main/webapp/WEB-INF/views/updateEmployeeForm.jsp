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
	<form action="./updateEmployee" method="post">
		<table>
			<tr>
				<td>Emp ID</td>
				<td> : </td>
				<td><input type="number" name="empId" required></td>
			</tr>
			<tr>
				<td>Emp Name</td>
				<td> : </td>
				<td><input type="text" name="empName" required></td>
			</tr>
			<tr>
				<td>Emp Salary</td>
				<td> : </td>
				<td><input type="number" name="salary" required></td>
			</tr>
			<tr>
				<td>Emp Age</td>
				<td> : </td>
				<td><input type="number" name="age" required></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td> : </td>
				<td><input type="text" name="position" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td> : </td>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td colspan="3" align="center">
					<br /><input type="submit" value="Update Employee">
				</td>
			</tr>
		</table>
	</form>
	<br><br>
	<%if (msg != null && !msg.isEmpty()) { %>
		<%=msg%>
	<%} %>
</body>
</html>
