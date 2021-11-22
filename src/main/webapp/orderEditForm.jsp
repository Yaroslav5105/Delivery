 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<form action="EditOrderController" method="post">
           idRoute: <select name="routeId">
               <c:forEach var="route" items="${routes}">
               <option value=<c:out value="${route.kilometers}" />>${route.way}</option>
               </c:forEach>
               </select>
                previous idRoute :<input  value="${order.way}" readonly/><br/>

         luggage: <select name="type">
         <c:forEach var="luggage" items="${luggages}">
         <option value=<c:out value="${luggage.type}" />>${luggage.type}</option>
         </c:forEach>
         </select>
         previous idRoute :<input  value="${order.type}" readonly/><br/>

        date :<input type="date"  name="date" max="2022-12-31" value="${order.date}" required/><br/>
 		User volume:<input type="volume" name="volume" value="${order.volume}" required/> <br/>
		User weight:<input type="weight" name="weight"  value="${order.weight}" required><br>
		<input type="hidden" name="orderId" value="${order.id}"/>
		<input type="submit" value="Save">
	</form>
</body>
</html>