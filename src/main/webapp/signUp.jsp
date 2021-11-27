<%@ page contentType="text/html; charset=UTF-8" %>
<html>
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
<div><center>      <h1>  Привет </h1>         </center></div>
        <form name="index.jsp" method="get" action="index.jsp">
        <input type="submit" value="back" />
        </form>
</center></div>

</body>
</html>