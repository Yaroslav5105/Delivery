<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<div class="lc-block">
 <div><center>

        <c:if test="${not empty errorMessage}">
        <p><c:out value="${errorMessage}" /></p>
        </c:if> </br>

        <form  method="post" action="/controller">
        <input type="hidden" name="command" value="creatUser"/>

        Username: <input  name="name" maxlength="20" min="2"  placeholder="Name" required/></br>
        Password: <input type="password" name="password" placeholder="Password" required/> <br/>

        Number: <input type="text" name="number"  placeholder="+380" required/> <br/>
        <c:if test="${not empty Message}">
        <p><c:out value="${Message}" /></p>
        </c:if>

        Email: <input type="email" name="mail"  placeholder="Email" required/> <br/>
        <c:if test="${not empty error}">
        <p><c:out value="${error}" /></p>
        </c:if> <br/>

        <input type="submit" value="Login" />
        </form>
        <form name="index.jsp" method="get" action="index.jsp">
        <input type="submit" value="back" />
        </form>
</center></div>
</div>
</body>
</html>