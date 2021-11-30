<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><html>
<body>

 <div><center></br></br></br></br></br></br>

	<form  method="post" action="/controller">
            <input type="hidden" name="command" value="editUser"/>
		<fmt:message key="person.Account.Name" /><input name="login" value="${user.login}" required><br>
        <fmt:message key="login.login" /><input name="number" value="${user.number}" required><br>
		<fmt:message key="login.password" /> <input name="password" value="${user.password}" required><br>
		<fmt:message key="person.Account.Email" /><input name="email" value="${user.email}" readonly><br>
		<input type="hidden" name="id" value="${user.id}"/>
		<input type="hidden" name="page" value="${pageId}"/>
		<input type="submit" value=<fmt:message key="save" />>
	</form>
	</center></div>

</body>
</html>