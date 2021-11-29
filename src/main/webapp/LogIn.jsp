<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" %>

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
         email: <input type="email" name="email"/></br>
         password: <input type="password" name="password"/></br>
        <input type="submit" value="Authenticate" />
        </form></br>

        <form name="index.jsp" method="get" action="index.jsp">
        <input type="submit" value="back" />
        </form>
</center></div>

</body>
</html>