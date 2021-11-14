 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form name="CountOrderServlet" method="post" action="CountOrderServlet">
       idRoute: <select name="idRoute">
               <c:forEach var="route" items="${routes}">
               <option value="${route.value}">${route.key}</option>
               </c:forEach>
               </select>
            <br/>
        volume: <input type="volume" name="volume" />  <br/>
        weight: <input type="weight" name="weight"/> <br/>
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