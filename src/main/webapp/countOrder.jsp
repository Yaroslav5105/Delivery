 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
 <form  method="get" action="/controller">
       <input type="hidden" name="command" value="countOrder"/>
          idRoute: <select name="idRoute">
               <c:forEach var="route" items="${routes}">
               <option value=<c:out value="${route.kilometers}" />>${route.way}</option>
               </c:forEach>
               </select>
            <br/>
        volume: <input type="number" name="volume"  placeholder="Volume" required/>  <br/>
        weight: <input type="number" name="weight" placeholder="Weight" required/> <br/>
        <input type="submit" value="order" />
        <br/><br/>
    </form>

</br>
   <form name="IndexAuthenticateUser.jsp" method="post" action="IndexAuthenticateUser.jsp">
               <input type="submit" value="menu" />
           </form>
    </body>
    </html>