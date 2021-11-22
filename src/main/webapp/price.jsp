 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
             <form name="ViewPriceController" method="post" action="ViewPriceController">
                     <table border="3"
                     style="border-color: black;">
                            <tr> <td>way</td> <td>kilometers</td></tr>
                            <c:forEach var="route" items="${routes}"  >
                            <tr> <td>${route.way}</td> <td>${route.kilometers} km</td></tr>
                            </c:forEach>
                            </select>
             </form>
            <form name="ViewPriceController" method="post" action="ViewPriceController">
                                 <table border="3"
                                 style="border-color: black;">
                                        <tr> <td>kilometer</td> <td>Volume, m3</td><td>weight , kg</td></tr>
                                        <c:forEach var="price" items="${prices}"  >
                                        <tr> <td>${price.kilometer} hryvnia per kilometer </td> <td>${price.volume} hryvnia per volume, 1 m3 </td><td>${price.weight} hryvnia per weight , 1 kg </td></tr>
                                        </c:forEach>
                                        </select>
                         </form>
                         </br>

</body>
</html>