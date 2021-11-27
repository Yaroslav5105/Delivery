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
      					    <th>Id User</th>
      						<th>Name</th>
      						<th>Number</th>
      						<th>Email</th>
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

                						<tr>
                						    <td><c:out value="${order.id}" /></td>
                							<td><c:out value="${order.way}" /></td>
                							<td><c:out value="${order.volume}" /></td>
                							<td><c:out value="${order.weight}" /></td>
                                            <td><c:out value="${order.date}" /></td>
                                            <td><c:out value="${order.type}" /></td>
                							<td><c:out value="${order.price}" /></td>
                                            <td><c:out value="${order.payment}" /></td>

                						</tr>
                				</tbody>
                			</table>
      		</div>
      	</div>
<div><center>
</br></br>

               <a  href="/controller?command=listOrderManager&page=1">
               <input type="submit" value="View manager List Order" /></href></br></br>

               <a  href="/controller?command=ListUserManager&page=1">
               <input type="submit" value="View manager List User" /></href></br></br>
</center></div>

</body>
</html>