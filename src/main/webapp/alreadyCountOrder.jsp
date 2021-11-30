 <%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <fmt:setLocale value="${sessionScope.locale}" />
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

 <div><center></br></br></br></br></br></br>

                        <fmt:message key="manager.List.Route.way" /><input name="way" value="${way}" readonly><br>
                		<fmt:message key="manager.List.Order.Weight" /><input name="weight" value="${weight}" required><br>
                        <fmt:message key="manager.List.Order.Volume" /><input name="volume" value="${volume}" required><br>

   <table border="3"
       style="border-color: black;">
   <tr> <td>Price</td> <td>${count}</td></tr>
</table>
</br>
        <a href="/controller?command=dataCountOrder">
        <input type="submit" value=<fmt:message key="count.yet" /> /></href>

            <a href="/controller?command=dataForOrder">
            <input type="submit" value=<fmt:message key="indexAuthenticateUser.order" /> /></href>
            </center></div>

    </body>
    </html>