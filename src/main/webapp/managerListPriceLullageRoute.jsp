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
			<h3 class="text-center">List of Routes</h3>
			<hr>
			<div class="container text-left">

				<a href="routeManager.jsp" class="btn btn-success">Add New Route </a>
			</div>
			<br/>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Way</th>
						<th>Kilometers</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="Route" items="${Routes}">
						<tr>
							<td><c:out value="${Route.id}" /></td>
							<td><c:out value="${Route.way}" /></td>
							<td><c:out value="${Route.kilometers}" /></td>

				            <td>
				            <a href="/controller?command=dataEditRoute&id=${Route.id}">
				            <input type="submit" value="edit" /></a>

							<a href="/controller?command=deleteRoute&id=${Route.id}">
							<input type="submit" value="Delete" /></a>

                          	</td>
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

</body>
</html>