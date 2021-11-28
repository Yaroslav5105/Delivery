 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page contentType="text/html; charset=UTF-8" %>

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
			<h3 class="text-center">List of Users id for larger , page = ${page}</h3>
			<hr>
			<div class="container text-left">

				<a href="/controller?command=dateForInsertUser&idpage=${page}" class="btn btn-success">Add New User</a>
			</div>
			<br/>
            <form  method="get" action="/controller">
                    <input type="hidden" name="command" value="findUser"/>
			find id user <input type="volume" name="userId" required />
			<input type="submit" value="find">
			</form>
			<br>

            <form  method="get" action="/controller">
            <input type="hidden" name="command" value="ListUserManager"/>
            <input type="hidden" name="page" value="1"/>
            <input type="submit" value="sort for id for smaller">
            </form>

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
					<c:forEach var="User" items="${sort}">
						<tr>
							<td><a href="/controller?command=findUser&userId=${User.id}">
                             <input type="submit" value="${User.id}" /></a></td>
							<td><c:out value="${User.login}" /></td>
							<td><c:out value="${User.number}" /></td>
							<td><c:out value="${User.email}" /></td>

				            <td>
				            <a href="/controller?command=dateForEditUser&id=${User.id}&idpage=${page}">
				            <input type="submit" value="edit" /></a>

							<a href="/controller?command=deleteUser&id=${User.id}&idpage=${page}">
							<input type="submit" value="Delete" /></a>

							<a href="/controller?command=dateOrderManager&id=${User.id}">
                            <input type="submit" value="add order" /></a>
                          	</td>
						</tr>
					</c:forEach>

				</tbody>

				        <a href='/controller?command=sortIdUserForLarger&page=1'><h5>1 </a>
                        <a href='/controller?command=sortIdUserForLarger&page=2'>2     </a>
                        <a href='/controller?command=sortIdUserForLarger&page=3'>3     </a>
                        <a href='/controller?command=sortIdUserForLarger&page=4'>4      </a>
                        <a href='/controller?command=sortIdUserForLarger&page=5'>5</h5> </a>
			</table>
		</div>
	</div>
        <form name="maneger.jsp" method="post" action="maneger.jsp">
        <input type="submit" value="menu" />
        </form>
</body>
</html>