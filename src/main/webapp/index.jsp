<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
<html>
<body>
       <a  href="/controller?command=locale&Locale=en&adress=index.jsp">
       <input type="submit" value="EN" /></href></br></br>
        <a  href="/controller?command=locale&Locale=ua&adress=index.jsp">
        <input type="submit" value="UA" /></href></br></br>
 <div><center></br></br></br></br></br></br>

        <a  href="/controller?command=dataForAuthenticate">
        <input type="submit" value=<fmt:message key="index.authorization" /> /></href></br></br>

        <a  href="/controller?command=dataFotCrearteUser">
        <input type="submit" value=<fmt:message key="index.registration" /> /></href></br></br>

        <form name="maneger.jsp" method="get" action="maneger.jsp">
        <input type="submit" value=<fmt:message key="index.manager" /> />
        </form>

</center></div>

</body>
</html>