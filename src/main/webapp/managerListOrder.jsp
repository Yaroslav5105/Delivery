<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

            				<a href="addorder.jsp" class="btn btn-success">Add New Order</a>
            			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Route</th>
						<th>Volume</th>
						<th>Weight</th>
						<th>Price</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${Order.id}" /></td>
							<td><c:out value="${Order.idUser}" /></td>
							<td><c:out value="${Order.idRoute}" /></td>
							<td><c:out value="${Order.volume}" /></td>
							<td><c:out value="${Order.weight}" /></td>
							<td><c:out value="${Order.price}" /></td>

							<td><a href="managerEditOrder.jsp">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="deleteOrder.jsp">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
	<form name="index.jsp" method="post" action="index.jsp">
            <input type="submit" value="to the main page" />
        </form>
        <form name="DeleteOrderServlet" method="post" action="DeleteOrderServlet">
                            delete Order: <input type="deleteorder" name="deleteorder"/>
                            <input type="submit" value="deleter" />
           </form>
</body>
</html>