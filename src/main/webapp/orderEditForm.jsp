 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<form action="EditOrderManagerServlet" method="post">
           idRoute: <select name="idRoute">
               <c:forEach var="route" items="${routes}">
               <option value=<c:out value="${route.kilometers}" />>${route.way}</option>
               </c:forEach>
               </select><br/>
        luggage: <select name="type">
                                            <c:forEach var="luggage" items="${luggages}">
                                            <option value=<c:out value="${luggage.type}" />>${luggage.type}</option>
                                            </c:forEach>
                                            </select>
                             <br/>
        date :<input type="date"  name="date" max="2022-12-31"/><br/>
 		User volume:<input type="volume" name="volume"/> <br/>
		User weight:<input type="weight" name="weight" ><br>
		<input type="hidden" name="idOrder" value=${order.id}/>
		<input type="submit" value="Save">
	</form>
</body>
</html>