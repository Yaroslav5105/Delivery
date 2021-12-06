<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<style>
.btnnn{
            background: #1dabb8; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            width: 5 px;
            margin: 10px; /* отступы */
            padding: 12px 10px; /* оступы для текста */
            margin-right: 640px;

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
  .btnn{
              background: #08B807; /* фон */
              border-radius: 5px; /* закругленные углы */
              color: #fff; /* цвет текста */
              font-weight: bold; /* жирный текст */
              margin: 10px; /* отступы */
              padding: 5px 10px; /* оступы для текста */

  }
.btnnk{
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
            background: #fffacd; /* Цвет фона таблицы */
           }
           TH {
            background: #1dabb8; /* Цвет фона заголовка */
            color: white; /* Цвет текста */
            text-align: left; /* Выравнивание по левому краю */
           }
           TD, TH {
            padding: 3px; /* Поля вокруг текста */
           }</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="row">
		<div class="container">
			<h3 class="text-center"><fmt:message key="list.sort.small" /> ${page}</h3>
			<hr>
			<div class="container text-left">
				<a href="/controller?command=dateForInsertUser&idpage=${page}" class="btn btn-success"><fmt:message key="manager.List.User.AddUser" /></a>
			</div>
			<br/>

            <form  class="btnnn"   method="get" action="/controller">
            <input type="hidden" name="command" value="findUser"/>
			<fmt:message key="find.user" /><input type="volume" name="userId" required />
			<input type="submit" value=<fmt:message key="manager.List.Order.find" /> >
			</form>
			<br>

            <form class="btnnn" method="get" action="/controller">
                                    <input type="hidden" name="command" value="sort"/>
                                    <fmt:message key="sorti" /><select name="page">

                                    <option value="sortMax" /> id , min - max </option>
                                    <option value="sortMin" /> id , max - min </option>

                                    </select>
                                    <input type="submit" value=<fmt:message key="use" />  >
                                    </form>

			<table class="table table-bordered">
				<thead>
					<tr>
						<th><fmt:message key="manager.List.Order.Id" /></th>
                        <th><fmt:message key="manager.List.Order.Id.Name" /></th>
						<th><fmt:message key="mamager.List.number" /></th>
                        <th><fmt:message key="mamager.List.email" /></th>
						<th><fmt:message key="manager.List.Order.Actions" /></th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="User" items="${listUsers}">
						<tr>
							<td><a href="/controller?command=findUser&userId=${User.id}">
                             <input type="submit" value="${User.id}" /></a></td>
							<td><c:out value="${User.login}" /></td>
							<td><c:out value="${User.number}" /></td>
							<td><c:out value="${User.email}" /></td>

				            <td>
				            <a href="/controller?command=dateForEditUser&id=${User.id}&idpage=${page}">
                            <input class="bbtn" type="submit" value=<fmt:message key="manager.List.Order.edit" /> /></a>

							<a href="/controller?command=deleteUser&id=${User.id}&idpage=${page}">
                            <input class="bttn" type="submit" value=<fmt:message key="manager.List.Order.delete" /> /></a>

							<a href="/controller?command=dateOrderManager&id=${User.id}">
                            <input class="btnn" type="submit" value=<fmt:message key="mamager.List.add.Order" /> /></a>
                          	</td>
						</tr>
					</c:forEach>

				</tbody>

				        <a href='/controller?command=ListUserManager&page=1'><h5>1 </a>
                        <a href='/controller?command=ListUserManager&page=2'>2     </a>
                        <a href='/controller?command=ListUserManager&page=3'>3     </a>
                        <a href='/controller?command=ListUserManager&page=4'>4      </a>
                        <a href='/controller?command=ListUserManager&page=5'>5</h5> </a>
			</table>
		</div>
	</div>
        <form name="maneger.jsp" method="post" action="maneger.jsp">
        <input class="btnnk" type="submit" value=<fmt:message key="manager.List.Order.menu" /> />
        </form>


</body>
</html>