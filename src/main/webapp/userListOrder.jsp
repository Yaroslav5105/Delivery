<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>

.bttn{
            background: #1dabb8; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 5px 8px; /* оступы для текста */
}
.btnn{
            background: #1dabb8; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 12px 20px; /* оступы для текста */
}
TABLE {

    width: 600px; /* Ширина таблицы */
    border-bottom: 2px solid maroon; /* Линия внизу таблицы */
    background: #2c3338; /* Цвет фона таблицы */
   }
   TD, TH{
    background: #2c3338; /* Цвет фона заголовка */
    color: #F4F4F4; /* Цвет текста */
    text-align: left; /* Выравнивание по левому краю */
   }
   TD, TH {
    padding: 3px; /* Поля вокруг текста */
   }
   </style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
</head>
<body>

<style>
body{
            background: #2c3338	; /* цвет фона страницы */
}

</style><br>

	<div class="row">

		<div class="container">
			<h3 class="text-center" style="color:#23C1C5 " ><fmt:message key="my.Order" /></h3>
			<hr>
			<table class="table table-bordered">
				<thead>
					<tr>
					    <th><fmt:message key="manager.List.Order.Id" /></th>
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
                            <td>
                            <c:if test="${Order.payment eq 'not paid'}">
							<a href="/controller?command=dataPayment&id=${Order.id} ">
            		        <input class="bttn"  type="submit" value=<fmt:message key="pay.Order" />>
							</c:if>
							 </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
<form name="IndexAuthenticateUser.jsp" method="post" action="IndexAuthenticateUser.jsp">
<input class="btnn" type="submit" value=<fmt:message key="person.Account.user" />>

</body>
</html>