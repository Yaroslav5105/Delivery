<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
<html locale="ua" class="desktop-view"><head>

<link rel="stylesheet" id="pp-normalize-css" href="https://pinkpointmedia.com/wp-content/themes/pp/css/normalize.css" type="text/css" media="all">
<link rel="stylesheet" id="pp-styles-css" href="https://pinkpointmedia.com/wp-content/themes/pp/css/styles.css" type="text/css" media="all">

<body class="home page-template-default page page-id-5">
<header class="">

<div class="container">
<a class="logo" href="maneger.jsp"><img src="http://www.dejurka.ru/wp-content/uploads/2009/10/animallogodesign1.png"  width="225" height="160" alt="PinkPoint"></a>

<a class="menu-switch tablet-hide desktop-hide" href="#"><span>Menu</span></a>

<nav class="menu-primary-container">

          <ul id="menu-primary" class="menu"><li id="menu-item-836" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-836">
          <a href="/controller?command=formPriceOrder"><fmt:message key="price" /></a></li><li id="menu-item-33" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-33">
          <a href="/controller?command=listOrderManager&page=1"><fmt:message key="manager.listOrderManager" /></a></li><li id="menu-item-33" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-33">
          <a href="/controller?command=ListUserManager&page=1"><fmt:message key="manager.ListUserManager" /></a></li><li id="menu-item-130" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-130">
          <a href="/controller?command=ListRoute"><fmt:message key="manager.ListRoute" /></a></li><li id="menu-item-130" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-130">
          <a href="/controller?command=locale&Locale=en&adress=maneger.jsp">EN</a></li><li id="menu-item-399" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-399">
          <a href="/controller?command=locale&Locale=ua&adress=maneger.jsp">UA</a></li><li id="menu-item-399" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-399">
          <a href="index.jsp"><fmt:message key="to.the.main" /></a></li></ul>
       </nav>
   </div>
</header>


           <div class="intro">
           <div class="img-bg">
           <div class="img" style="background-image:url(https://assets.volvo.com/is/image/VolvoInformationTechnologyAB/volvo-fh-lng-on-road-performance?qlt=82&wid=1440&ts=1624603810311&fit=constrain)"></div>
    </div>

              <div class="intro__content">
           <h1> <fmt:message key="manager" /></h1>
      </div>
   </div>
<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</body>
</html>