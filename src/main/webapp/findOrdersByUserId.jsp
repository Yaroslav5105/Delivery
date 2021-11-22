<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>User Management Application</title>
      <link rel="stylesheet"
      	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      	crossorigin="anonymous">
      </head>
      <body>
      	<div class="row">
      		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

      		<div class="container">
      			<h3 class="text-center">Data user</h3>
      			<hr>
      			<div class="container text-left">

      			</div>
      			<br/>

      			<br>
      			<table class="table table-bordered">
      				<thead>
      					<tr>
      						<th>Name</th>
      						<th>Number</th>
      						<th>Email</th>
      					</tr>
      				</thead>
      				<tbody>
      						<tr>
      							<td><c:out value="${user.login}" /></td>
      							<td><c:out value="${user.number}" /></td>
      							<td><c:out value="${user.email}" /></td>


      						</tr>

      				</tbody>

      			</table>
      			<table class="table table-bordered">
                				<thead>
                					<tr>
                					    <th>Id Order</th>
                						<th>Route</th>
                						<th>Volume</th>
                						<th>Weight</th>
                						<th>Date</th>
                						<th>type of luggage</th>
                						<th>Price</th>
                						<th>Pay</th>
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