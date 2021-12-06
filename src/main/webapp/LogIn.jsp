<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
       body {

       	background-color: #2c3338;
       	color: #606468;
       	font-family: 'Open Sans', Arial, sans-serif;
       	font-size: 14px;
       	line-height: 1.5em;
       }

       a {
       	color: #eee;
       	text-decoration: none;
       }

       a:hover {
       	text-decoration: underline;
       }

       input {
       	border: none;
       	font-family: 'Open Sans', Arial, sans-serif;
       	font-size: 14px;
       	line-height: 1.5em;
       	padding: 0;
       	-webkit-appearance: none;
       }

       p {
       	line-height: 1.5em;
       }

       .clearfix { *zoom: 1; } /* For IE 6/7 */
       .clearfix:before, .clearfix:after {
       	display: table;
       	content: "";
       }
       .clearfix:after { clear: both; }

       /* ---------- LOGIN ---------- */

       #login {
       	margin: 150px auto;
       	width: 280px;
       }

       #login form span {
       	background-color: #363b41;
       	border-radius: 3px 0px 0px 3px;
       	-moz-border-radius: 3px 0px 0px 3px;
       	-webkit-border-radius: 3px 0px 0px 3px;
       	color: #606468;
       	display: block;
       	float: left;
       	height: 50px;
       	line-height: 50px;
       	text-align: center;
       	width: 50px;
       }
.btnn{
               background: #1dabb8; /* фон */
               border-radius: 5px; /* закругленные углы */
               color: #fff; /* цвет текста */
               font-weight: bold; /* жирный текст */
               margin: 10px; /* отступы */
               padding: 12px 20px; /* оступы для текста */
   }
       #login form input {
       	height: 50px;
       	outline:none;
       }

       #login form input[type="text"], input[type="password"] {
       	background-color: #3b4148;
       	border-radius: 0px 3px 3px 0px;
       	-moz-border-radius: 0px 3px 3px 0px;
       	-webkit-border-radius: 0px 3px 3px 0px;
       	color: #606468;
       	margin-bottom: 1em;
       	padding: 0 16px;
       	width: 198px;
       }



       #login form input[type="submit"] {
       	border-radius: 3px;
       	-moz-border-radius: 3px;
       	-webkit-border-radius: 3px;
       	background-color: #ea4c88;
       	color: #eee;
       	font-weight: bold;
       	margin-bottom: 2em;
       	text-transform: uppercase;
       	cursor:pointer;
       	width: 280px;
       }

       #login form input[type="submit"]:hover {
       	background-color: #1dabb8;
       }

       #login > p {
       	text-align: center;
       }

       #login > p span {
       	padding-left: 5px;
       }

       </style>
	<meta charset="UTF-8">

</head>
<body>
<form name="index.jsp" method="get" action="index.jsp">
<input class="btnn" type="submit" value=<fmt:message key="person.Account.user" />>
</form>
    <div id="login">
    <div><center></br>
     <c:if test="${not empty errorMessage}">
            <p><c:out value="${errorMessage}" /></p>
            </c:if> </center></div></br>
        <form method="post" action="/controller">
        <input type="hidden" name="command" value="authenticate"/>
            <fieldset class="clearfix">
                <p><span class="fontawesome-user"></span><input type="text" name="email" value="" size="40" placeholder=<fmt:message key="user.email" />  required></p>
                <p><span class="fontawesome-lock"></span><input type="password"  name="password" value="" size="40" placeholder=<fmt:message key="login.password" /> required></p>
                <p><input type="submit" value=<fmt:message key="index.authorization" />  ></p>
            </fieldset>
        </form>
        <p><fmt:message key="don'reg" /> &nbsp;&nbsp;<a href="/controller?command=dataFotCrearteUser"><fmt:message key="index.registration" /></a><span class="fontawesome-arrow-right"></span></p>
    </div>
</body>
</html>