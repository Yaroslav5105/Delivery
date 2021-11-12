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
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-left">

				<a href="adduser.jsp" class="btn btn-success">Add New User</a>
			</div>
			<br/>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>number</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="User" items="${listUser}">

						<tr>
							<td><c:out value="${User.id}" /></td>
							<td><c:out value="${User.login}" /></td>
							<td><c:out value="${User.password}" /></td>
							<td><c:out value="${User.number}" /></td>

							<td><a href="managerEditUser.jsp">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="deleteuser.jsp">Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
	<form name="index.jsp" method="post" action="index.jsp">
            <input type="submit" value="to the main page" />
        </form>

</body>
</html>