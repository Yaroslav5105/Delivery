<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
 <div><center></br></br></br></br></br></br>
    <form  method="post" action="/controller">
                <input type="hidden" name="command" value="dataForAuthenticate"/>
                <input type="submit" value="Авторизация" />
                </form>

            <form  method="post" action="/controller">
            <input type="hidden" name="command" value="dataFotCrearteUser"/>
            <input type="submit" value="Регистрация" />
            </form>

        <form name="maneger.jsp" method="get" action="maneger.jsp">
        <input type="submit" value="manager" />
        </form>

</center></div>



</body>
</html>