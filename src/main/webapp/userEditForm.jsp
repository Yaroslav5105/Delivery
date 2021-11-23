 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<form action="EditUserController" method="post">
		Username:<input name="login" value="${user.login}" required><br>
        Username number :<input name="number" value="${user.number}" required><br>
		User password: <input name="password" value="${user.password}" required><br>
		User email:<input name="email" value="${user.email}" readonly><br>
		<input type="hidden" name="id" value="${user.id}"/>
		<input type="hidden" name="page" value="${pageId}"/>
		<input type="submit" value="Save">
	</form>
</body>
</html>