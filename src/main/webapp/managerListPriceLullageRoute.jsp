 <%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
.btnnk{
            background: #1dabb8; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 12px 20px; /* оступы для текста */
}
.bbtn{
             background: #FFD700; /* фон */
             border-radius: 5px; /* закругленные углы */
             color: #fff; /* цвет текста */
             font-weight: bold; /* жирный текст */
             margin: 10px; /* отступы */
             padding: 5px 10px; /* оступы для текста */
 }
.btnn{
              background:#FF0000; /* фон */
              border-radius: 5px; /* закругленные углы */
              color: #fff; /* цвет текста */
              font-weight: bold; /* жирный текст */
              margin: 10px; /* отступы */
              padding: 5px 10px; /* оступы для текста */

  }
 TABLE {
            width: 650px; /* Ширина таблицы */
            border-bottom: 2px solid maroon; /* Линия внизу таблицы */
            background: #fffacd; /* Цвет фона таблицы */
           }
           TH {
            background: #1dabb8; /* Цвет фона заголовка */
            color: white; /* Цвет текста */
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
                            <input   class="bbtn" type="submit" value=<fmt:message key="manager.List.Order.edit" /> /></a>

							<a href="/controller?command=deleteRoute&id=${Route.id}">
                            <input class="btnn" type="submit" value=<fmt:message key="manager.List.Order.delete" /> /></a>
                          	</td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>
	</div>
        <form name="maneger.jsp" method="post" action="maneger.jsp">
        <input class="btnnk" type="submit" value=<fmt:message key="manager.List.Order.menu" /> />
        </form>
</body>
</html>