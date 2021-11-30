 <%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<div class="row">
		<div class="container">
			<h3 class="text-center"><fmt:message key="manager.List.Route" /></h3>
			<hr>
			<div class="container text-left">

				<a href="routeManager.jsp" class="btn btn-success"><fmt:message key="manager.List.Add.Route" /></a>
			</div>
			<br/>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th><fmt:message key="manager.List.Order.Id" /></th>
						<th><fmt:message key="manager.List.Route.way" /></th>
						<th><fmt:message key="manager.List.Route.Kilometers" /></th>
						<th><fmt:message key="manager.List.Order.Actions" /></th>
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
                            <input type="submit" value=<fmt:message key="manager.List.Order.edit" /> /></a>

							<a href="/controller?command=deleteRoute&id=${Route.id}">
                            <input type="submit" value=<fmt:message key="manager.List.Order.delete" /> /></a>
                          	</td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
        <form name="maneger.jsp" method="post" action="maneger.jsp">
        <input type="submit" value=<fmt:message key="manager.List.Order.menu" /> />
        </form>
</body>
</html>