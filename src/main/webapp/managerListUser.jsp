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
			<h3 class="text-center">List of Users ${page}</h3>
			<hr>
			<div class="container text-left">

				<a href="LoginUserController?idpage=${page}" class="btn btn-success">Add New User</a>
			</div>
			<br/>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Number</th>
						<th>Email</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="User" items="${listUsers}">
						<tr>
							<td><a href="FindOrdersByUserManagerController?userId=${User.id}">
                             <input type="submit" value="${User.id}" /></a></td>
							<td><c:out value="${User.login}" /></td>
							<td><c:out value="${User.number}" /></td>
							<td><c:out value="${User.email}" /></td>

				            <td>
				            <a href="EditUserController?id=${User.id}&idpage=${page}">
				            <input type="submit" value="edit" /></a>

							<a href="DeleteUserController?id=${User.id}&idpage=${page}">
							<input type="submit" value="Delete" /></a>

							<a href="OrderManagerController?id=${User.id}">
                            <input type="submit" value="add order" /></a>
                          	</td>
						</tr>
					</c:forEach>

				</tbody>

				        <a href='ListUsersManagerController?page=1'><h5>1 </a>
                        <a href='ListUsersManagerController?page=2'>2     </a>
                        <a href='ListUsersManagerController?page=3'>3</h5> </a>
			</table>
		</div>
	</div>
        <form name="maneger.jsp" method="post" action="maneger.jsp">
                            <input type="submit" value="menu" />
                        </form>
            </body>

</body>
</html>