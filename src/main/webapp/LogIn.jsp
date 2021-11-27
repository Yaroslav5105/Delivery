<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
 <div><center>
    <form  method="post" action="/controller">
         <input type="hidden" name="command" value="authenticate"/>
         email: <input type="email" name="email"/></br>
         password: <input type="password" name="password"/></br>
        <input type="submit" value="Authenticate" />
        </form></br>


        <form name="index.jsp" method="get" action="index.jsp">
        <input type="submit" value="back" />
        </form>
</center></div>

</body>
</html>