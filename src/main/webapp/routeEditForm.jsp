 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<form action="EditRouteController" method="post">
		Username:<input name="way" value="${route.way}" required><br>
        Username number :<input name="kilometers" value="${route.kilometers}" required><br>
            <input type="hidden" name="id" value="${idroute}"/>
		<input type="submit" value="Save">
	</form>
</body>
</html>