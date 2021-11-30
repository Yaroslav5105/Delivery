<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
<html>
<body>

 <div><center></br></br></br></br></br></br>

<form  method="post" action="/controller">
        <input type="hidden" name="command" value="PayOrder"/>
    <fmt:message key="pay.number" /> <input type="number" placeholder="number card"required/> <br/>
    <fmt:message key="pay.srok" /><input type="number" placeholder="validity" required/></br>
    <fmt:message key="pay" /><input type="number" placeholder="CVV"required/> <br/>
    <input type="hidden" name="id" value="${orderId}"/>
    <input type="submit" value="pay" />
</form>
</center></div>

</body>
</html>