 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	 <form  method="post" action="/controller">
        <input type="hidden" name="command" value="insertRoute"/>
		starting point: <input name="a"  required><br>
		end point	: <input name="b"  required><br>
        distance :<input name="kilometers" required><br>
		<input type="submit" value="Save">
	</form>
</body>
</html>