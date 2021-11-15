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
        volume: <input type="volume" name="volume"/> <br/>
        weight: <input type="weight" name="weight"/> <br/>
        <input type="submit" value="order" />
        <br/><br/>
    </form>
    <form name="manager.jsp" method="post" action="maneger.jsp">
                    <input type="submit" value="back" />
     </form>

    </body>
    </html>