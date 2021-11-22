<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<body>
<form name="loginForm" method="post" action="LoginUserController" accept-charset="utf-8">
    Username: <input type="text" name="name" required/> <br/>
    Password: <input type="password" name="password" required/> <br/>
    Number: <input type="number" name="number" required/> <br/>
    Email: <input type="email" name="mail" required/> <br/>
    <input type="submit" value="Login" />
</form>

 <form name="maneger.jsp" method="post" action="maneger.jsp">
                <input type="submit" value="back" />
            </form>
</body>
</html>