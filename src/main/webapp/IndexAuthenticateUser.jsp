 <%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <fmt:setLocale value="${sessionScope.locale}" />
 <html>
 <body>
        <a  href="/controller?command=locale&Locale=en&adress=IndexAuthenticateUser.jsp">
        <input type="submit" value="EN" /></href></br></br>
         <a  href="/controller?command=locale&Locale=ua&adress=IndexAuthenticateUser.jsp">
         <input type="submit" value="UA" /></href></br></br>
  <div><center></br></br></br></br></br></br>

     <a href="/controller?command=dataCountOrder">
     <input type="submit" value=<fmt:message key="indexAuthenticateUser.count" /> /></href>
<br>

 <a href="/controller?command=price">
     <input type="submit" value=<fmt:message key="indexAuthenticateUser.price" /> /></href>
</br >
    <a href="/controller?command=listOrder">
    <input type="submit" value=<fmt:message key="indexAuthenticateUser.MyOrder" /> /></href>
</br>
        <a href="/controller?command=dataForOrder">
     <input type="submit" value=<fmt:message key="indexAuthenticateUser.order" /> /></href>

</br>

     <a href="/controller?command=dataPersonAccount">
        <input type="submit" value=<fmt:message key="indexAuthenticateUser.Account" /> /></href>
</center></div>

 </body>
 </html>