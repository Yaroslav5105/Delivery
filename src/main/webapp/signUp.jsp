<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
<html>
<body>

<div class="lc-block">
 <div><center>

        <c:if test="${not empty errorMessage}">
        <p><c:out value="${errorMessage}" /></p>
        </c:if> </br>

        <form  method="post" action="/controller">
        <input type="hidden" name="command" value="creatUser"/>

         <fmt:message key="user.name" /> <input  name="name" maxlength="20" min="2"  placeholder="Name" required/></br>
         <fmt:message key="login.password" /> <input type="password" name="password" placeholder="Password" required/> <br/>
         <fmt:message key="user.number" /> <input type="text" name="number"  placeholder="+380" required/>

        <c:if test="${not empty Message}">
        <p><c:out value="${Message}" /></p>
        </c:if>

        <fmt:message key="user.email" /> <input type="email" name="mail"  placeholder="Email" required/> <br/>
        <c:if test="${not empty error}">
        <p><c:out value="${error}" /></p>
        </c:if>

        <input type="submit" value=<fmt:message key="index.registration" /> />
        </form>
        <form name="index.jsp" method="get" action="index.jsp">
        <input type="submit" value=<fmt:message key="person.Account.user" /> />
        </form>
</center></div>
</div>
</body>
</html>