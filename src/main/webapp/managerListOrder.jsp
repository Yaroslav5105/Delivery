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
			<h3 class="text-center">List of Order ${page}</h3>
			<hr>

			<div class="container text-left">

            				<a href="ListUsersManagerController?page=1" class="btn btn-success">Add New Order</a>

            			</div>
			<br>
            <form action="FindOrdersByUserManagerController" method="get">
			find id user <input type="volume" name="userId" required />
			<input type="submit" value="find">
			</form>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>ID Name</th>
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
							<td><c:out value="${Order.id}" /></td>
							<td><a href="FindOrdersByUserManagerController?userId=${Order.idUser}">
                            <input type="submit" value="${Order.idUser}" /></a></td>
							<td><c:out value="${Order.way}" /></td>
							<td><c:out value="${Order.volume}" /></td>
							<td><c:out value="${Order.weight}" /></td>
                            <td><c:out value="${Order.date}" /></td>
                            <td><c:out value="${Order.type}" /></td>
                            <td><c:out value="${Order.price}" /></td>
                            <td><c:out value="${Order.payment}" /></td>
							<td>
							<a href="EditOrderController?id=${Order.id}&idpage=${page}">
                            <input type="submit" value="edit" /></a>

							<a href="DeleteOrderController?id=${Order.id}&idpage=${page}">
                            <input type="submit" value="Delete" /></a> </td>
						</tr>
					</c:forEach>
				</tbody>
				        <a href='ListOrdersManagerController?page=1'><h5>1 </a>
                        <a href='ListOrdersManagerController?page=2'>2     </a>
                        <a href='ListOrdersManagerController?page=3'>3</h5> </a>
			</table>
		</div>
	</div>

	<form name="maneger.jsp" method="post" action="maneger.jsp">
            <input type="submit" value="menu" />
        </form>

</body>
</html>