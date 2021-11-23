 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form name="CountOrderController" method="post" action="CountOrderController">
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

   <table border="3"
       style="border-color: black;">
   <tr> <td>Price</td> <td>${count}</td></tr>
</table>
</br>
   <form name="index.jsp" method="post" action="index.jsp">
               <input type="submit" value="menu" />
           </form>
    </body>
    </html>