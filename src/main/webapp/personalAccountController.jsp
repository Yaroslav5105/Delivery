 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
            <form action="PersonalAccountController" method="get">
                    Id:<input name="login" value="${user.id}" readonly><br>
            		Name:<input name="login" value="${user.login}" required><br>
                    Number number :<input name="number" value="${user.number}" required><br>
            		Email:<input name="email" value="${user.email}" readonly><br>
            		<input type="submit" value="Save">
            	</form>
</body>
</html>