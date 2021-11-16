 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<form action="EditOrderManagerServlet" method="post">
           idRoute: <select name="idRoute">
               <c:forEach var="route" items="${routes}">
               <option value=<c:out value="${route.kilometers}" />>${route.way}</option>
               </c:forEach>
               </select><br/>

 		User volume:<input type="volume" name="volume"/> <br/>
		User weight:<input type="weight" name="weight" ><br>
		<input type="submit" value="Save">
	</form>
</body>
</html>