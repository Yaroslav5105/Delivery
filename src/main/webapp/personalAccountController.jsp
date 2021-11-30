<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

<div><center></br></br></br></br></br></br>
            <form  method="post" action="/controller">
                    <input type="hidden" name="command" value="editPersonAccount"/>

                    <fmt:message key="person.Account.id" /><input name="id" value="${user.id}" readonly><br>
            		<fmt:message key="person.Account.Name" /><input name="login" value="${user.login}" required><br>
            		<input type="hidden" name="password" value="user.password"/>
                    <fmt:message key="person.Account.Number" /><input name="number" value="${user.number}" required><br>
            		<fmt:message key="person.Account.Email" /><input name="email" value="${user.email}" readonly><br>
            		<input type="submit" value=<fmt:message key="person.Account.edit" />>
            	</form>
            	<form name="IndexAuthenticateUser.jsp" method="get" action="IndexAuthenticateUser.jsp">
                <input type="submit" value=<fmt:message key="person.Account.user" />>
                </center></div>
</body>
</html>