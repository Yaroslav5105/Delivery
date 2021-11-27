<%@ page language="java" contentType="text/html; charset=cp1251"
         pageEncoding="cp1251" %>
<html>
<head>
    <meta charset="cp1251">
</head>
<body>
 <div><center>
    <form  method="post" action="/controller">
        <input type="hidden" name="command" value="creatUser"/>
        Username: <input type="text" name="name"  placeholder="Name" required/> <br/>
        Password: <input type="password" name="password" placeholder="Password" required/> <br/>
        Number: <input type="number" name="number" placeholder="Number" required/> <br/>
        Email: <input type="email" name="mail"  placeholder="Email" required/> <br/>
        <input type="submit" value="Login" />
    </form>

        <form name="index.jsp" method="get" action="index.jsp">
        <input type="submit" value="back" />
        </form>
</center></div>

</body>
</html>