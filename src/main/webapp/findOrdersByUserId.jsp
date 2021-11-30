<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
      <link rel="stylesheet"
      	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      	crossorigin="anonymous">
      </head>
      <body>

      	<div class="row">

      		<div class="container">
      			<h3 class="text-center"><fmt:message key="data.user" /></h3>
      			<hr>
      			<div class="container text-left">

      			</div>
      			<br/>

      			<br>
      			<table class="table table-bordered">
      				<thead>
      					<tr>
      					    <th><fmt:message key="manager.List.Order.Id.Name" /></th>
                            <th><fmt:message key="user.name" /></th>
                            <th><fmt:message key="login.login" /></th>
                            <th><fmt:message key="user.email" /></th>
      					</tr>
      				</thead>
      				<tbody>
      						<tr>
      						    <td><c:out value="${user.id}" /></td>
      							<td><c:out value="${user.login}" /></td>
      							<td><c:out value="${user.number}" /></td>
      							<td><c:out value="${user.email}" /></td>
      						</tr>
      				</tbody>

      			</table>
      			<table class="table table-bordered">
                				<thead>
                					<tr>
                					   <th><fmt:message key="id.Order" /></th>
                                       <th><fmt:message key="manager.List.Order.Route" /></th>
                                       <th><fmt:message key="manager.List.Order.Volume" /></th>
                                       <th><fmt:message key="manager.List.Order.Weight" /></th>
                                       <th><fmt:message key="manager.List.Order.Date" /></th>
                                       <th><fmt:message key="manager.List.Order.Type" /></th>
                                       <th><fmt:message key="manager.List.Order.price" /></th>
                                       <th><fmt:message key="manager.List.Order.Pay" /></th>
                					</tr>
                				</thead>
                				<tbody>
                					<c:forEach var="Order" items="${listOrders}">

                						<tr>
                						    <td><c:out value="${Order.id}" /></td>
                							<td><c:out value="${Order.way}" /></td>
                							<td><c:out value="${Order.volume}" /></td>
                							<td><c:out value="${Order.weight}" /></td>
                                            <td><c:out value="${Order.date}" /></td>
                                            <td><c:out value="${Order.type}" /></td>
                							<td><c:out value="${Order.price}" /></td>
                                            <td><c:out value="${Order.payment}" /></td>

                						</tr>
                					</c:forEach>
                				</tbody>
                			</table>
      		</div>
      	</div>



</body>
</html>