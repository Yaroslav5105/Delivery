<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
 <div><center>
    <form  method="post" action="/controller">
        <input type="hidden" name="command" value="creatUser"/>
        Username: <input  name="name" maxlength="20" pattern="[A-Za-zА-Яа-я]{4,}"  placeholder="Name" required/> <br/>
        Password: <input type="password" name="password" placeholder="Password" required/> <br/>
        Number: <input type="text" name="number" pattern="-?(\d+|\d+.\d+|.\d+)([eE][-+]?\d+)?" placeholder="+380" min="12" required/> <br/>
        Email: <input type="email" name="mail"  placeholder="Email" required/> <br/>
        <input type="submit" value="Login" />
    </form>
        <form name="index.jsp" method="get" action="index.jsp">
        <input type="submit" value="back" />
        </form>
</center></div>

</body>
</html>