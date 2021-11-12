 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
 <body>
<form name="OrderServlet" method="post" action="OrderServlet">
        idUser: <input type="idUser" name="idUser"/> <br/>
        idRoute:
            <select name="idRoute">
                <c:forEach var="route" items="${routes}">
                    <option value="${route.value}">${route.key}</option>
                </c:forEach>
            </select>
            <br/>
        volume: <input type="volume" name="volume"/> <br/>
        weight: <input type="weight" name="weight"/> <br/>
        <input type="submit" value="order" />
        <br/><br/>
    </form>
    <form name="managerListUser.jsp" method="post" action="managerListUser.jsp">
                    <input type="submit" value="back" />
                </form>
    </body>
    </html>