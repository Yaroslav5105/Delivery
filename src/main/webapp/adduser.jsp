<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%><html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<form  method="post" action="/controller" accept-charset="utf-8">
         <input type="hidden" name="command" value="insertUser"/>
    Username: <input type="text" name="name"  placeholder="Name" required/> <br/>
    Password: <input type="password" name="password" placeholder="Password" required/> <br/>
    Number: <input type="number" name="number" placeholder="Number" required/> <br/>
    Email: <input type="email" name="mail"  placeholder="Email" required/> <br/>
    	   <input type="hidden" name="page" value="${pageId}"/>
    <input type="submit" value="Login" />
</form>

 <form name="maneger.jsp" method="post" action="maneger.jsp">
                <input type="submit" value="back" />
            </form>
</body>
</html>