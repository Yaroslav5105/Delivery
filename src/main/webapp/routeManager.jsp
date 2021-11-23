 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<form action="RouteManagerController" method="post">
		Way : <input name="way"  required><br>
        distance :<input name="kilometers" required><br>

		<input type="submit" value="Save">
	</form>
</body>
</html>