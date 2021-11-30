<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
<html>
<head>
       <a  href="/controller?command=locale&Locale=en&adress=maneger.jsp">
       <input type="submit" value="EN" /></href></br></br>
        <a  href="/controller?command=locale&Locale=ua&adress=maneger.jsp">
        <input type="submit" value="UA" /></href></br></br>
<div><center>
</br></br>

               <a  href="/controller?command=listOrderManager&page=1">
               <input type="submit" value=<fmt:message key="manager.listOrderManager" /> /></href></br></br>

               <a  href="/controller?command=ListUserManager&page=1">
               <input type="submit" value=<fmt:message key="manager.ListUserManager" /> /></href></br></br>

               <a  href="/controller?command=ListRoute">
               <input type="submit" value=<fmt:message key="manager.ListRoute" /> /></href></br></br>
</center></div>

</body>
</html>