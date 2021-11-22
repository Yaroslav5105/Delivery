 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="row">

		<div class="container">
			<h3 class="text-center">my orders</h3>
			<hr>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Route</th>
						<th>Volume</th>
						<th>Weight</th>
						<th>Date</th>
						<th>type of luggage</th>
						<th>Price</th>
						<th>Pay</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="Order" items="${listOrders}">

						<tr>
							<td><c:out value="${Order.way}" /></td>
							<td><c:out value="${Order.volume}" /></td>
							<td><c:out value="${Order.weight}" /></td>
                            <td><c:out value="${Order.date}" /></td>
                            <td><c:out value="${Order.type}" /></td>
							<td><c:out value="${Order.price}" /></td>
                            <td><c:out value="${Order.payment}" /></td>
                            <td>
							<a href="PayOrderController?id=${Order.id}&userId=${Order.idUser} ">
                            <input type="submit" value="pay" /></a>
							 </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
<form name="IndexAuthenticateUser.jsp" method="get" action="IndexAuthenticateUser.jsp">
<input type="submit" value="user" />
</form>
</body>
</html>