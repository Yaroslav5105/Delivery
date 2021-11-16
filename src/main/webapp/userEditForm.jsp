 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<form action="EditUserManagerServlet" method="post">
		Username:<input name="login" value="${user.login}"><br>
        Username number :<input name="number" value="${user.number}"><br>
		User password: <input name="password" value="${user.password}"><br>
		User email:<input name="email" value="${user.email}" ><br>
		<input type="submit" value="Save">
	</form>
</body>
</html>