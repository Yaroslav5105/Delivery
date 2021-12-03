<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
body{
            background: #fffacd; /* цвет фона страницы */
}
.Myform{
            width:300px; /* ширина блока */
            height: 470px; /* высота блока */
            background: #fff; /* фон блока */
            border-radius: 10px; /* закругленные углы блока */
            margin: 5% auto; /* отступ сверху и выравнивание по середине */
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
.btnn{
            background: #1dabb8; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 12px 20px; /* оступы для текста */
}
.btn{
            background: #1dabb8; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            float: right; /* выравнивание справа */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 12px 37px; /* оступы для текста */
}
.bbtn{
            background: #1dabb8; /* фон */
            border-radius: 5px; /* закругленные углы */
            color: #fff; /* цвет текста */
            float: right; /* выравнивание справа */
            font-weight: bold; /* жирный текст */
            margin: 10px; /* отступы */
            padding: 12px 20px; /* оступы для текста */
}
.info{
            width:1301px; /* ширина */
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
            <h1><fmt:message key="calculete" /></h1>
            <div class="inp">
                         <form  method="get" action="/controller">
                                   <input type="hidden" name="command" value="dataCountOrder"/>
                                   <input type="hidden" name="page" value="countOrder.jsp"/>

                                   <fmt:message key="manager.List.Route.way" /><input class="log" name="way" value="${way}" readonly >
                                   <fmt:message key="manager.List.Order.Weight" /><input class="pass" name="weight" value="${weight}" readonly>
                                   <fmt:message key="manager.List.Order.Volume" /><input class="log" name="volume" value="${volume}" readonly >
                                   <fmt:message key="indexAuthenticateUser.price" /><input class="log" name="volume" value="${count}" readonly   >
                                   <div class="info">

                                   </div>
                                   <input class="bbtn" type="submit" value=<fmt:message key="count.yet" /> >
                        </form>
                         <form  method="get" action="/controller">
                                 <input type="hidden" name="command" value="dataForOrder"/>
                                  <input class="btn" type="submit" value=<fmt:message key="indexAuthenticateUser.order" /> >

</form>
            </div>
</div>
<form name="IndexAuthenticateUser.jsp" method="post" action="IndexAuthenticateUser.jsp">
               <input class="btnn" type="submit" value=<fmt:message key="person.Account.user" /> />
           </form>
</body>
</html>