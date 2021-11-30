<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

 <div><center></br></br></br></br></br></br>

<form  method="post" action="/controller">
        <input type="hidden" name="command" value="editOrder"/>
           <fmt:message key="manager.List.Edit.way" /> <select name="routeId">
               <c:forEach var="route" items="${routes}" >
               <option value=<c:out value="${route.kilometers}" />>${route.way}</option>
               </c:forEach>
               </select><br/>

         <fmt:message key="luggage" /> <select name="type">
         <c:forEach var="luggage" items="${luggages}">
         <option value=<c:out value="${luggage.type}" />>${luggage.type}</option>
         </c:forEach>
         </select><br/>


        <fmt:message key="data.date" /><input type="date"  name="date" max="2022-12-31" value="${order.date}" required/><br/>
 		<fmt:message key="data.volume" /><input type="volume" name="volume" value="${order.volume}" required/> <br/>
		<fmt:message key="data.weight" /><input type="weight" name="weight"  value="${order.weight}" required><br>
		<input type="hidden" name="orderId" value="${order.id}"/>
		<input type="hidden" name="page" value="${pageId}"/>

		<input type="submit" value=<fmt:message key="save" />>

<br/><br/><br/><br/>
		<fmt:message key="previous.way" /><input  value="${order.way}" readonly/><br/>
		<fmt:message key="previous.luggage" /><input  value="${order.type}" readonly/><br/>

	</form>
	</center></div>

</body>
</html>