<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
.btnn{
            background: #1dabb8; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 12px 20px; /* оступы для текста */
}
TABLE {
    width: 650px; /* Ширина таблицы */
    border-bottom: 2px solid maroon; /* Линия внизу таблицы */
    background: #2c3338; /* Цвет фона таблицы */
   }
   TD, TH {
    background: #2c3338; /* Цвет фона заголовка */
    color: #FFFFFF ; /* Цвет текста */
    text-align: left; /* Выравнивание по левому краю */
   }
   TD, TH {
    padding: 3px; /* Поля вокруг текста */
   }
   </style>
      <link rel="stylesheet"
      	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      	crossorigin="anonymous">
      </head>
      <body>
<style>
body{
            background: #2c3338	; /* цвет фона страницы */
}

</style><br>
      	<div class="row">

      		<div class="container">
      			<h3 class="text-center" style="color:#23C1C5 " ><fmt:message key="data.user" /></h3>
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
               <input class="btnn" type="submit" value=<fmt:message key="View.Order" /> /></href></br></br>

               <a  href="/controller?command=ListUserManager&page=1">
               <input class="btnn" type="submit" value=<fmt:message key="Veiw.User" /> /></href></br></br>
</center></div>

</body>
</html>