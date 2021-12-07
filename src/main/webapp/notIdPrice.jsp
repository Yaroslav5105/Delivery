 <%@ page contentType="text/html; charset=UTF-8" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></br></br>

 <body bgcolor="#2c3338">
  <style>

   TABLE {
    width: 550px; /* Ширина таблицы */
    border-bottom: 2px solid maroon; /* Линия внизу таблицы */
    background: #2c3338; /* Цвет фона таблицы */
   }
   TD {
    background: #2c3338; /* Цвет фона заголовка */
    color: #E6E6E6; /* Цвет текста */
    text-align: left; /* Выравнивание по левому краю */
   }
   TD, TH {
    padding: 3px; /* Поля вокруг текста */
   }

   .btnn{
               background: #1dabb8; /* фон */
               border-radius: 5px; /* закругленные углы */
               color: #fff; /* цвет текста */
               font-weight: bold; /* жирный текст */
               margin: 10px; /* отступы */
               padding: 12px 20px; /* оступы для текста */
   }
  </style>

  <form name="index.jsp" method="get" action="index.jsp">
  <input class="btnn" type="submit" value=<fmt:message key="person.Account.user" />>

  <div><center></br></br></br>

             <form name="ViewPriceController" method="post" action="ViewPriceController">
                     <table border="3"
                     style="border-color: #D0D0D0">
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
                style="border-color: #D0D0D0">
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