<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
.bttn{
            background: #D15656; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 5px 10px; /* оступы для текста */
}
.bbtn{
            background: #D3D033; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 5px 10px; /* оступы для текста */
}
.btnn{
            background: #1dabb8; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 12px 20px; /* оступы для текста */
}
.btnnn{
            background: #2c3338; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            width: 5 px;
            margin: 10px; /* отступы */
            padding: 12px 10px; /* оступы для текста */
            margin-right: 600px;

}
   TABLE {
    width: 700px; /* Ширина таблицы */
    border-bottom: 2px solid maroon; /* Линия внизу таблицы */
    background: #2c3338; /* Цвет фона таблицы */
   }
   TD,TH {
    background: #2c3338; /* Цвет фона заголовка */
    color: #FFFFFF; /* Цвет текста */
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
			<h3 class="text-center" style="color:#23C1C5 "><fmt:message key="manager.List.Order" /> ${page}</h3>
			<hr>

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
					<c:forEach var="Order" items="${orders}">
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
                            <input class="bbtn"  type="submit" value=<fmt:message key="manager.List.Order.edit" /> /></a>

							<a href="/controller?command=deleteOrder&id=${Order.id}&idpage=${page}">
                            <input class="bttn"  type="submit" value=<fmt:message key="manager.List.Order.delete" /> /></a> </td>
                            </c:if>
						</tr>
					</c:forEach>
				</tbody>

</table>
		</div>
</body>
</html>