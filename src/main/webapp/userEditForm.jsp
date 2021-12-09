<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
body{
            background: #2c3338	; /* цвет фона страницы */
}
.btnn{
            background: #1dabb8; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 12px 20px; /* оступы для текста */
}
.Myform{
            width:300px; /* ширина блока */
            height: 410px; /* высота блока */
            background: #fff; /* фон блока */
            border-radius: 10px; /* закругленные углы блока */
            margin: 10% auto; /* отступ сверху и выравнивание по середине */
            box-shadow: 2px 2px 4px 0px #000000; /* тень блока */
}
.Myform h1 {
            margin: 0; /* убираем отступы */
            background-color: #282830; /* фон заголовка */
            border-radius: 10px 10px 0 0; /* закругляем углы сверху */
            color: #fff; /* цвет текста */
            font-size: 14px; /* размер шрифта */
            padding: 20px; /* отступы */
            text-align: center; /* выравниваем текст по центру */
            text-transform: uppercase; /* все символы заглавные */
}
.inp{
            padding:20px; /* отступы */
}
.log{
            border: 1px solid #dcdcdc; /* рамка */
            padding: 12px 10px; /* отступы текста */
            width: 260px; /* ширина */
            border-radius: 5px 5px 0 0; /* закругленные углы сверху */
}
.pass{
            border: 1px solid #dcdcdc; /* рамка */
            padding: 12px 10px; /* отступы текста */
            width: 260px; /* ширина */
            border-radius: 0px 0px 5px 5px; /* закругленные углы снизу */
}
.btn{
            background: #1dabb8; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            float: right; /* выравнивание справа */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 12px 20px; /* оступы для текста */
}
.info{
            width:130px; /* ширина */
            float: left; /* выравнивание слева */
            padding-top: 20px; /* оступ сверху для текста */
a{
            color:#999; /* цвет ссылки */
            text-decoration: none; /* убираем подчеркивание */

}
a:hover{
            color: #1dabb8; /* цвет ссылки при наведении */

}
</style>
</head>
<body>

<div class="Myform">
            <h1><fmt:message key="chance.user"/></h1>
            <div class="inp">
                        <form  method="post" action="/controller">
                                   <input type="hidden" name="command" value="editUser"/>
            		               <input type="hidden" name="id" value="${user.id}"/>
                                   <input type="hidden" name="page" value="${pageId}"/>

                                   <fmt:message key="person.Account.Name"/><input class="log" name="login" pattern="^[A-Za-zА-Яа-яЁё]+$"  value="${user.login}" required>
                                   <fmt:message key="login.login"/><input class="log"name="number" value="${user.number}" required>
                                   <fmt:message key="login.password"/><input class="log"  name="password" value="${user.password}" required>
                                   <fmt:message key="person.Account.Email"/><input class="log" name="email" value="${user.email}" readonly >
                                   <div class="info">
                                              <c:if test="${not empty errorMessage}">
                                              <p><c:out value="${errorMessage}" /></p>
                                              </c:if>
                                   </div>
                                   <input class="btn" type="submit" value=<fmt:message key="save" />>
                        </form>
            </div>
</div>
<form name="maneger.jsp" method="post" action="maneger.jsp">
               <input class="btnn" type="submit" value=<fmt:message key="person.Account.user" /> />
           </form>
</body>
</html>