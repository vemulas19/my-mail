<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function deleteEmployee(mail) {
	alert("delete triggered for : " + mail);
	document.forms[0].action="${pageContext.request.contextPath}/deleteEmployee?mail="+mail;
	document.forms[0].method="post";
	document.forms[0].submit();
}
function openInEditMode(mail) {
	alert("open in edit mode triggered!!" + mail);
	document.forms[0].action="${pageContext.request.contextPath}/openInEditMode?email="+mail;
	document.forms[0].method="post";
	document.forms[0].submit();
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="<core:url value="j_spring_security_logout" />" > Logout</a></br></br>
<form action="">
<table border="2" >
<tr style="color:red" >
	<th>Name</th>
	<th>Mail</th>
	<th>Mobile</th>
</tr>
	<core:forEach var="employee" items="${empList}" >
		<tr>
            <td><core:out value="${employee.empName}"/></td>
            <td><core:out value="${employee.mail}"/></td>  
            <td><core:out value="${employee.mbl}"/></br></td>
            <td><input type="button" value="Edit" onclick="openInEditMode('${employee.mail}')" /> </td>            
            <td><input type="button" value="Delete" onclick="deleteEmployee('${employee.mail}')" /> </td>
         </tr>
    </core:forEach>
</table>
</form>
</body>
</html>