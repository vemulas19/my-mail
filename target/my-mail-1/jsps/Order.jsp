<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="">
Item Type
<select name="itemTypes">
 <core:forEach var="itemType" items="${itemTypeList}" >
	<option value="${itemType.itemTypeId}">${itemType.itemType}</option>
 </core:forEach>
</select>
</br>
<input type="submit" value="Place Order"/>
</form>
</body>
</html>