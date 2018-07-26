<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function getEmployees() {
	document.forms[0].action="${pageContext.request.contextPath}/getEmployees";
	document.forms[0].method="get";
	document.forms[0].submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${message}
<form action="registerEmployee">
Name : <input type="text" name="empName"/></br>
Mobile : <input type="text" name="mbl"/></br>
Email : <input type="text" name="mail"/></br>
Password : <input type="text" name="password"/></br>
<input type="submit" value="Register"/>
<input type="button" value="view Employees" onclick="getEmployees()"/>
</form>
<a href="${pageContext.request.contextPath}/jsps/login.jsp">Login Here</a>
</body>
</html>