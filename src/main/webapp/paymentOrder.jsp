<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<body>
<form  method="post" action="/controller">
        <input type="hidden" name="command" value="PayOrder"/>
    number card <input type="number" placeholder="number card"required/> <br/>
    date card<input type="number" placeholder="date card" required/>
    3 number<input type="number" placeholder="3 number"required/> <br/>
    <input type="hidden" name="id" value="${orderId}"/>
    <input type="submit" value="pay" />
</form>
</body>
</html>