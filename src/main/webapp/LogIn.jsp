<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<div><center>

        <c:if test="${not empty errorMessage}">
         <p><c:out value="${errorMessage}" /></p>
         </c:if> </br>

         <form  method="post" action="/controller">
         <input type="hidden" name="command" value="authenticate"/>
         <fmt:message key="user.email" /> <input type="email" name="email"/></br>
         <fmt:message key="login.password" /> <input type="password" name="password"/></br></br>
        <input type="submit" value=<fmt:message key="index.authorization" /> />
        </form></br>

        <form name="index.jsp" method="get" action="index.jsp">
        <input type="submit" value=<fmt:message key="person.Account.user" /> />
        </form>
</center></div>

</body>
</html>