<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" id="pp-normalize-css" href="https://pinkpointmedia.com/wp-content/themes/pp/css/normalize.css" type="text/css" media="all">
<link rel="stylesheet" id="pp-styles-css" href="https://pinkpointmedia.com/wp-content/themes/pp/css/styles.css" type="text/css" media="all">
<div class="col width1-2">
<div class="contact-form">
 <div><center>

<div class="row fieldset first">

 <c:if test="${not empty errorMessage}">
        <p><c:out value="${errorMessage}" /></p>
        </c:if> </br>
<form  method="post" action="/controller">
        <input type="hidden" name="command" value="creatUser"/>
	<div class="col width1-2">
		<span class="wpcf7-form-control-wrap first-name"><input type="text" name="name" value="" size="40" placeholder=<fmt:message key="user.name" /> class="wpcf7-form-control wpcf7-text wpcf7-validates-as-required" id="form-first-name" aria-required="true" aria-invalid="false"></span>
		<label for="form-first-name"><fmt:message key="user.name" /><span class="required">*</span></label>
	</div>
	</div>
 <div class="row fieldset">
	<div class="col width1-2">
		<span class="wpcf7-form-control-wrap last-name"><input type="text" name="password" value="" size="40" placeholder=<fmt:message key="login.password" /> class="wpcf7-form-control wpcf7-text wpcf7-validates-as-required" id="form-last-name" aria-required="true" aria-invalid="false"></span>
		<label for="form-last-name"><fmt:message key="login.password" /><span class="required">*</span></label>
	</div>
</div>

<div class="row fieldset">
	<div class="col width1-2">
		<span class="wpcf7-form-control-wrap phone"><input type="text" name="number" value="" size="40" placeholder=<fmt:message key="user.number" />  class="wpcf7-form-control wpcf7-text" id="form-phone" aria-invalid="false"></span>
		<label for="form-phone"><fmt:message key="user.number" /> </label>
	</div>
</div>

<div class="row fieldset">
	<div class="col width1-2">
		<span class="wpcf7-form-control-wrap email"><input type="email" name="mail" value="" size="40" placeholder=<fmt:message key="user.email" /> class="wpcf7-form-control wpcf7-text wpcf7-email wpcf7-validates-as-required wpcf7-validates-as-email" id="form-email" aria-required="true" aria-invalid="false"></span>
		<label for="form-email"><fmt:message key="user.email" /><span class="required">*</span></label>
	</div>
	</div>
 <input type="submit" value=<fmt:message key="index.registration" /> />
  </form>
</center></div>

<div class="wpcf7-response-output" aria-hidden="true"></div></form></div>

<form name="index.jsp" method="get" action="index.jsp">
        <input type="submit" value=<fmt:message key="person.Account.user" /> />
        </form>
			</div>
				</div>
</body>
</html>