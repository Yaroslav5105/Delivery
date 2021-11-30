<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
 <title>Delivery</title>
 <body>
  <div><center></br></br></br></br></br></br>

<form  method="post" action="/controller">
        <input type="hidden" name="command" value="orderManager"/>
        <fmt:message key="manager.List.Route.way" /> <select name="routeId">
                       <c:forEach var="route" items="${routes}">
                       <option value=<c:out value="${route.kilometers}" />>${route.way} </option>
                       </c:forEach>
                       </select><br/>

        <fmt:message key="luggage" /> <select name="type">
        <c:forEach var="luggage" items="${luggages}">
        <option value=<c:out value="${luggage.type}" />>${luggage.type}</option>
        </c:forEach>
        </select><br/>
        <fmt:message key="manager.List.Order.Date" /><input type="date"  name="date" max="2022-12-31"  required /><br/>
        <fmt:message key="manager.List.Order.Volume" /><input type="volume" name="volume"  pattern="^[ 0-9]+$" placeholder="Volume" required/> <br/>
        <fmt:message key="manager.List.Order.Weight" /> <input type="weight" name="weight" pattern="^[ 0-9]+$" placeholder="Weight"  required/> <br/>
        <input type="hidden" name="id" value="${user}"/><br/>
        <input type="submit" value=<fmt:message key="indexAuthenticateUser.order" /> />
        <br/>
    </form>
    <form name="manager.jsp" method="post" action="maneger.jsp">
                    <input type="submit" value=<fmt:message key="person.Account.user" /> />
     </form>
</center></div>

    </body>
    </html>