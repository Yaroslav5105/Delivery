<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>

 <div><center></br></br></br></br></br></br>

 <form  method="get" action="/controller">
       <input type="hidden" name="command" value="countOrder"/>
          <fmt:message key="manager.List.Edit.way" /> <select name="idRoute">
               <c:forEach var="route" items="${routes}">
               <option value=<c:out value="${route.kilometers}" />>${route.way}</option>
               </c:forEach>
               </select>
            <br/>
        <fmt:message key="manager.List.Order.Volume" /> <input type="number" name="volume"  placeholder="Volume" required/>  <br/>
        <fmt:message key="manager.List.Order.Weight" /> <input type="number" name="weight" placeholder="Weight" required/> <br/><br/>
        <input type="submit" value=<fmt:message key="indexAuthenticateUser.order" /> />
        <br/>
    </form>

   <form name="IndexAuthenticateUser.jsp" method="post" action="IndexAuthenticateUser.jsp">
               <input type="submit" value=<fmt:message key="person.Account.user" /> />
           </form>
</center></div>
    </body>
    </html>