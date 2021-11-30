<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
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
			<h3 class="text-center"><fmt:message key="list.sort" />  ${page}</h3>
			<hr>

			<div class="container text-left">
            <a href="/controller?command=ListUserManager&page=1"" class="btn btn-success"><fmt:message key="manager.List.Order.Add.User" /></a>
            </div>
			<br>

            <form  method="get" action="/controller">
            <input type="hidden" name="command" value="findOrderforIdOrder"/>
			find id user <input type="volume" name="userId" required />
			<input type="submit" value=<fmt:message key="manager.List.Order.find" /> >
			</form>

			<form  method="get" action="/controller">
            <input type="hidden" name="command" value="listOrderManager"/>
            <input type="hidden" name="page" value="1"/>
            <input type="submit" value=<fmt:message key="list.sort.id" /> >
            </form>

            <form  method="get" action="/controller">
            <input type="hidden" name="command" value="sortDateForLarge"/>
            <input type="hidden" name="page" value="1"/>
            <input type="submit" value=<fmt:message key="list.sort.larger" /> >
            </form>

			<table class="table table-bordered">
				<thead>
					<tr>
						<th><fmt:message key="manager.List.Order.Id" /></th>
                        <th><fmt:message key="manager.List.Order.Id.Name" /></th>
                        <th><fmt:message key="manager.List.Order.Route" /></th>
                        <th><fmt:message key="manager.List.Order.Volume" /></th>
                        <th><fmt:message key="manager.List.Order.Weight" /></th>
                        <th><fmt:message key="manager.List.Order.Date" /></th>
                        <th><fmt:message key="manager.List.Order.Type" /></th>
                        <th><fmt:message key="manager.List.Order.price" /></th>
                        <th><fmt:message key="manager.List.Order.Pay" /></th>
                        <th><fmt:message key="manager.List.Order.Actions" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="Order" items="${sort}">
						<tr>
						    <td><a href="/controller?command=findOrderforIdOrder&userId=${Order.id}">
                            <input type="submit" value="${Order.id}" /></a></td>

							<td><c:out value="${Order.idUser}" /></td>
							<td><c:out value="${Order.way}" /></td>
							<td><c:out value="${Order.volume}" /></td>
							<td><c:out value="${Order.weight}" /></td>
                            <td><c:out value="${Order.date}" /></td>
                            <td><c:out value="${Order.type}" /></td>
                            <td><c:out value="${Order.price}" /></td>
                            <td><c:out value="${Order.payment}" /></td>
							<td>
							<c:if test="${Order.payment eq 'not paid'}">
							<a href="/controller?command=dateEditOrder&id=${Order.id}&idpage=${page}">
                            <input type="submit" value=<fmt:message key="manager.List.Order.edit" /> /></a>


                            <a href="/controller?command=deleteOrder&id=${Order.id}&idpage=${page}">
                             <input type="submit" value=<fmt:message key="manager.List.Order.delete" /> /></a> </td>
                             </c:if>
                             </td>
						</tr>
					</c:forEach>
				</tbody>
				        <a href='/controller?command=sortDate&page=1'><h5>1 </a>
                        <a href='/controller?command=sortDate&page=2'>2     </a>
                        <a href='/controller?command=sortDate&page=3'>3     </a>
                        <a href='/controller?command=sortDate&page=4'>4</h5> </a>
			</table>
		</div>
	</div>

    <form name="maneger.jsp" method="post" action="maneger.jsp">
    <input type="submit" value=<fmt:message key="manager.List.Order.menu" /> />
    </form>

</body>
</html>