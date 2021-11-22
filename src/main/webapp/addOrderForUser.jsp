 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
 <body>
<form name="OrderUserController" method="post" action="OrderUserController">
        idRoute: <select name="routeId">
                       <c:forEach var="route" items="${routes}">
                       <option value=<c:out value="${route.kilometers}" />>${route.way}</option>
                       </c:forEach>
                       </select>
        <br/>
        lluggega: <select name="type">
                               <c:forEach var="luggage" items="${luggages}">
                               <option value=<c:out value="${luggage.type}" />>${luggage.type}</option>
                               </c:forEach>
                               </select>
                <br/>
        date :<input type="date"  name="date" max="2022-12-31" required/><br/>
        volume: <input type="volume" name="volume" required/> <br/>
        weight: <input type="weight" name="weight" required/> <br/>
        <input type="hidden" name="userId" value="${userId}"/>
        <input type="submit" value="order" />
        <br/><br/>
    </form>
    <form name="IndexAuthenticateUser.jsp" method="get" action="IndexAuthenticateUser.jsp">
                    <input type="submit" value="back" />
     </form>

    </body>
    </html>