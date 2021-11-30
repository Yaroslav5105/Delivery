<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
</head>
<body>

<form  method="post" action="/controller" accept-charset="utf-8">
         <input type="hidden" name="command" value="insertUser"/>
    <fmt:message key="person.Account.Name" /> <input type="text" name="name"  placeholder="Name" required/> <br/>
    <fmt:message key="login.password" /> <input type="password" name="password" placeholder="Password" required/> <br/>
    <fmt:message key="login.login" /> <input type="number" name="number" placeholder="Number" required/> <br/>
    <fmt:message key="mamager.List.email" /> <input type="email" name="mail"  placeholder="Email" required/> <br/>
    	   <input type="hidden" name="page" value="${pageId}"/>
    <input type="submit" value=<fmt:message key="login" /> />
</form>

 <form name="maneger.jsp" method="post" action="maneger.jsp">
                <input type="submit" value=<fmt:message key="person.Account.user" /> />
            </form>
</body>
</html>