 <%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

 <div><center></br></br></br></br></br></br>
	<form  method="post" action="/controller">
                <input type="hidden" name="command" value="editRoute"/>
		<fmt:message key="manager.List.Edit.way" /><input name="way" value="${route.way}" required><br>
        <fmt:message key="manager.List.Edit.kilo" /><input name="kilometers" value="${route.kilometers}" required><br>
            <input type="hidden" name="id" value="${idroute}"/>
		<input type="submit" value=<fmt:message key="save" />>
	</form>
	</center></div>

</body>
</html>