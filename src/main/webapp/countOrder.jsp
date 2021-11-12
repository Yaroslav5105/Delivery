 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form name="CountOrderServlet" method="post" action="CountOrderServlet">
        idRoute:
            <select name="idRoute">
                <option value="150">Kharkiv - Poltava</option>
                <option value="700">Kharkiv - Lviv</option>
                <option value="500">Kharkiv - Kuev</option>
                <option value="350">Kharkiv - Dnepr </option>
            </select>
            <br/>
        volume: <input type="volume" name="volume" />  <br/>
        weight: <input type="weight" name="weight"/> <br/>
        <input type="submit" value="order" />
        <br/><br/>
    </form>

   <table border="1"
       style="border-color: black;">
   <tr> <td>Price</td> <td>${count}</td></tr>
    </body>
    </html>