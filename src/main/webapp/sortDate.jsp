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
.bbtn{
            background: #FFD700; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 5px 10px; /* оступы для текста */
}
.bttn{
            background: #FF0000; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 5px 10px; /* оступы для текста */
}
.btnnn{
            background: #1dabb8	; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            width: 5 px;
            margin: 10px; /* отступы */
            padding: 12px 10px; /* оступы для текста */
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
			<h3 class="text-center"><fmt:message key="list.sort" />  ${page}</h3>
			<hr>

			<div class="container text-left">
            <a href="/controller?command=ListUserManager&page=1"" class="btn btn-success"><fmt:message key="manager.List.Order.Add.User" /></a>
            </div>
			<br>

            <form class="btnnn" method="get" action="/controller">
            <input type="hidden" name="command" value="findOrderforIdOrder"/>
			<fmt:message key="find.user" /> <input type="volume" name="userId" required />
			<input type="submit" value=<fmt:message key="manager.List.Order.find" /> >
			</form>

			<form class="btnnn" method="get" action="/controller">
                        <input type="hidden" name="command" value="sort"/>
                        <fmt:message key="sorti" /><select name="page">

                        <option value="sortDate" /> 1 - 30 <fmt:message key="manager.List.Order.Date" /></option>
                        <option value="list" /> <fmt:message key="default" /></option>
                        <option value="Large" /> 30 - 1 <fmt:message key="manager.List.Order.Date" /> </option>

                        </select>
                        <input type="submit" value=<fmt:message key="use" />  >
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
                            <input  class="bbtn" type="submit" value=<fmt:message key="manager.List.Order.edit" /> /></a>


                            <a href="/controller?command=deleteOrder&id=${Order.id}&idpage=${page}">
                             <input class="bttn" type="submit" value=<fmt:message key="manager.List.Order.delete" /> /></a> </td>
                             </c:if>
                             </td>
						</tr>
					</c:forEach>
				</tbody>
							</table>

				        <a href='/controller?command=sortDate&page=1'><h5>1 </a>
                        <a href='/controller?command=sortDate&page=2'>2     </a>
                        <a href='/controller?command=sortDate&page=3'>3     </a>
                        <a href='/controller?command=sortDate&page=4'>4</h5> </a>
		</div>
	</div>

    <form name="maneger.jsp" method="post" action="maneger.jsp">
    <input class="btnn"  type="submit" value=<fmt:message key="manager.List.Order.menu" /> />
    </form>

</body>
</html>