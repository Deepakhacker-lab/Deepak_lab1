
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>



<!DOCTYPE html>

<html>
<head>

<title>
List of customer
</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

<div id="wrapper">

<div id="header">

<h2>CRM - customer relation management</h2>
</div>
</div>

<div id="container">

<div id="content">

<!-- put a new button add customer -->

<input type="button" value="Add Customer"
onclick="window.location.href='showFormforAdd'; return false;"
class="add-button"

/>

<!--  add out html table -->

<table>
<tr>
<th> First Name</th>

<th>Last Name</th>

<th>E mail</th>


</tr>
<!-- loop over and print over customer -->

<C:forEach var="tempCustomer" items="${Customers}">

<tr>

<td> ${tempCustomer.firstname}</td>
<td>${tempCustomer.lastname}</td>
<td>${tempCustomer.email}</td>


</tr>


</C:forEach>


</table>

</div>
</div>


</body>


</html>