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
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Order</h3>
			<hr>

			<div class="container text-left">

            				<a href="allUserServlet" class="btn btn-success">Add New Order</a>
            			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>ID Name</th>
						<th>Route</th>
						<th>Volume</th>
						<th>Weight</th>
						<th>Price</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="Order" items="${listOrder}">

						<tr>
							<td><c:out value="${Order.id}" /></td>
							<td><c:out value="${Order.idUser}" /></td>
							<td><c:out value="${Order.way}" /></td>
							<td><c:out value="${Order.volume}" /></td>
							<td><c:out value="${Order.weight}" /></td>
							<td><c:out value="${Order.price}" /></td>

							<td>
							<a href="EditOrderManagerServlet?id=${Order.id}">
                            <input type="submit" value="edit" /></a>

							<a href="DeleteOrderServlet?id=${Order.id}">
                            <input type="submit" value="Delete" /></a> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<form name="maneger.jsp" method="post" action="maneger.jsp">
            <input type="submit" value="menu" />
        </form>

</body>
</html>