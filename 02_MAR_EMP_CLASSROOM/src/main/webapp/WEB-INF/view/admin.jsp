<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	All Employee Details
<body>
<th>
<tr>
<table border = 2px>
<td>Name</td>
<td>Email</td>
<td>Salary</td>
<td>Admin</td>
<td>Password</td>
</tr>
</th>
<c:forEach var = "emp" items="${msg}">
	<tr>
	<td>${emp.name}</td>
	<td>${emp.email}</td>
	<td>${emp.salary}</td>
	<td>${emp.role}</td>
	<td>${emp.password}</td>
	</tr>
	
</c:forEach>
</th>

</table>
</body>
</head>
</html>