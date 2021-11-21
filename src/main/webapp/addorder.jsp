 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
 <body>
<form name="OrderServlet" method="post" action="OrderServlet">
        idRoute: <select name="idRoute">
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
        date :<input type="date"  name="date" max="2022-12-31"/><br/>
        volume: <input type="volume" name="volume"/> <br/>
        weight: <input type="weight" name="weight"/> <br/>
        <input type="hidden" name="id" value="${user}"/>
        <input type="submit" value="order" />
        <br/><br/>
    </form>
    <form name="manager.jsp" method="post" action="maneger.jsp">
                    <input type="submit" value="back" />
     </form>

    </body>
    </html>