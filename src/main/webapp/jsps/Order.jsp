<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function getItems(itemType) {
	alert("item type is  : " + itemType);
	document.forms[0].action="${pageContext.request.contextPath}/getItems?itemType="+itemType;
	document.forms[0].submit();
}
</script>
</head>
<body>
<form action="">
Item Type
<select name="itemType">
 <core:forEach var="itemType" items="${itemTypeList}" >
	<option value="${itemType.itemTypeId}" onclick="getItems('${itemType.itemTypeId}')">${itemType.itemType}</option>
 </core:forEach>
</select>
</br>
Item Type
<select name="items">
 <core:forEach var="item" items="${items}" >
	<option value="${item.itemId}" >${item.itemName}</option>
 </core:forEach>
</select>
</br>
<input type="submit" value="Place Order"/>
</form>
</body>
</html>