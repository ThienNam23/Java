<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="employee" method="post">
		<input type="text" name="eid" placeholder="EID(int)"><br> 
		<input type="text" name="ename" placeholder="EName(varchar)"><br> 
		<input type="text" name="deg" placeholder="Deg(varchar)"><br>
		<input type="text" name="salary" placeholder="Salary(int)"><br> 
		<input type="submit" value="Add Employee">
	</form>
	<form action="employee" method="delete">
		<input type="text" name="eid" placeholder="EID(int)"><br> 
		<input type="text" name="ename" placeholder="EName(varchar)"><br> 
		<input type="text" name="deg" placeholder="Deg(varchar)"><br>
		<input type="text" name="salary" placeholder="Salary(int)"><br> 
		<input type="submit" value="Add Employee">
	</form>
</body>
</html>