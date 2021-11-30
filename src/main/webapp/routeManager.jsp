<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

	 <form  method="post" action="/controller">
        <input type="hidden" name="command" value="insertRoute"/>
		<fmt:message key="starting.point" /> <input name="a"  required><br>
		<fmt:message key="end.point" /> <input name="b"  required><br>
        <fmt:message key="manager.List.Edit.kilo" /><input name="kilometers" required><br>
		<input type="submit" value="Save">
	</form>
</body>
</html>