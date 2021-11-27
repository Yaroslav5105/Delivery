 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
                        Way:<input name="way" value="${way}" readonly><br>
                		Weight:<input name="weight" value="${weight}" required><br>
                        Volume :<input name="volume" value="${volume}" required><br>

   <table border="3"
       style="border-color: black;">
   <tr> <td>Price</td> <td>${count}</td></tr>
</table>
</br>
        <a href="/controller?command=dataCountOrder">
        <input type="submit" value="count yet" /></href>

            <a href="/controller?command=dataForOrder">
            <input type="submit" value="Order" /></href>
    </body>
    </html>