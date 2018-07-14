<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="">
Name : <input type="text" name="empName" value="${employee.empName}" /></br>
Mobile : <input type="text" name="mbl" value="${employee.mbl}" /></br>
Email : <input type="text" name="mail" value="${employee.mail}"/></br>
Password : <input type="text" name="password" value="${employee.password}"/></br>
<input type="submit" value="Update">
</form>
</body>

</html>