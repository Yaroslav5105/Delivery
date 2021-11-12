<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

      	<br>
      	<div class="container col-md-5">
      		<div class="card">
      			<div class="card-body">
      				<c:if test="${user != null}">
      					<form action="update" method="post">
      				</c:if>
      				<c:if test="${user == null}">
      					<form action="insert" method="post">
      				</c:if>

      				<caption>
      					<h2>
      						<c:if test="${user != null}">
                  			Edit User
                  		</c:if>
      						<c:if test="${user == null}">
                  			Add New User
                  		</c:if>
      					</h2>
      				</caption>

      				<c:if test="${user != null}">
      					<input type="hidden" name="id" value="<cout value='${user.id}' />" />
      				</c:if>


      				<fieldset class="form-group">
      					<label>User Name</label> <input type="text"
      						value="" class="form-control"
      						name="name" required="required">
      				</fieldset>

      				<fieldset class="form-group">
      					<label>User Route</label> <input type="text"
      						value="" class="form-control"
      						name="email">
      				</fieldset>

      				<fieldset class="form-group">
      					<label>User Volume</label> <input type="text"
      						value="" class="form-control"
      						name="country">
      				</fieldset>

      				<fieldset class="form-group">
                       <label>User Weight</label> <input type="text"
                      value="" class="form-control"
                    name="country">
                       </fieldset>

      				<button type="submit" class="btn btn-success">Save</button>
      				</form>
      			</div>
      		</div>
      	</div>
      </body>
</html>