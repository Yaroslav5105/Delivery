 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
            <form  method="post" action="/controller">
                    <input type="hidden" name="command" value="editPersonAccount"/>

                    Id:<input name="id" value="${user.id}" readonly><br>
            		Name:<input name="login" value="${user.login}" required><br>
            		<input type="hidden" name="password" value="user.password"/>
                    Number number :<input name="number" value="${user.number}" required><br>
            		Email:<input name="email" value="${user.email}" readonly><br>
            		<input type="submit" value="edit">
            	</form>
            	<form name="IndexAuthenticateUser.jsp" method="get" action="IndexAuthenticateUser.jsp">
                <input type="submit" value="user" />
</body>
</html>