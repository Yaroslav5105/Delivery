 <%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></br></br>
<form name="IndexAuthenticateUser.jsp" method="get" action="IndexAuthenticateUser.jsp">
<input type="submit" value=<fmt:message key="person.Account.user" />>

<div><center></br></br></br>

             <form name="ViewPriceController" method="post" action="ViewPriceController">
                     <table border="3"
                     style="border-color: black;">
                            <tr>
                            <td><fmt:message key="manager.List.Route.way" /></td>
                            <td><fmt:message key="manager.List.Route.Kilometers" /></td>
                            </tr>

                            <c:forEach var="route" items="${routes}"  >
                            <tr> <td>${route.way}</td> <td>${route.kilometers} km</td></tr>
                            </c:forEach>
                            </select>
             </form>
            <form name="ViewPriceController" method="post" action="ViewPriceController">
                <table border="3"
                style="border-color: black;">
                <tr>
                 <td><fmt:message key="price.kilometer" /></td>
                 <td><fmt:message key="price.volume" /></td>
                 <td><fmt:message key="price.weight" /></td>
                 </tr>
                <c:forEach var="price" items="${prices}"  >
               <tr>
               <td>${price.kilometer} <fmt:message key="price.ht.kilomeetr" /></td>
               <td>${price.volume} <fmt:message key="price.ht.volume" /></td>
               <td>${price.weight} <fmt:message key="price.hr.weight" /> </td>
               </tr>
               </c:forEach>
               </select>
            </form>
            </br>


</center></div>

</body>
</html>