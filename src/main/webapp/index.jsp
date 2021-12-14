<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" />
<html locale="ua" class="desktop-view"><head>

<link rel="stylesheet" id="pp-normalize-css" href="https://pinkpointmedia.com/wp-content/themes/pp/css/normalize.css" type="text/css" media="all">
<link rel="stylesheet" id="pp-styles-css" href="https://pinkpointmedia.com/wp-content/themes/pp/css/styles.css" type="text/css" media="all">

	<body class="home page-template-default page page-id-5">
			<header class="">

		<div class="container">
			<a class="logo" href="index.jsp"><img src="http://www.dejurka.ru/wp-content/uploads/2009/10/animallogodesign1.png"  width="225" height="160" alt="PinkPoint"></a>

			<a class="menu-switch tablet-hide desktop-hide" href="#"><span>Menu</span></a>

			<nav class="menu-primary-container">
				<ul id="menu-primary" class="menu"><li id="menu-item-836" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-836">
				<a href="/controller?command=dataForAuthenticate"><fmt:message key="index.authorization" /></a></li><li id="menu-item-33" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-33">
				<a href="/controller?command=dataFotCrearteUser&wrongName=pol"><fmt:message key="index.registration" /></a></li><li id="menu-item-130" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-130">
				<a href="/controller?command=locale&Locale=en&adress=index.jsp">EN</a></li><li id="menu-item-399" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-399">
				<a href="/controller?command=locale&Locale=ua&adress=index.jsp">UA</a></li><li id="menu-item-619" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-619">
				<a href="maneger.jsp"><fmt:message key="index.manager" /></a></li></ul>
			</nav>
		</div>
	</header>


	<div class="intro  ">
		<div class="img-bg">
			<div class="img" style="background-image:url(https://gruzdx.com.ua/wp-content/uploads/2019/01/slider_111.jpg)"></div>
		</div>

		<div class="intro__content">
				<h1> <small><fmt:message key="mini.info" /></small><fmt:message key="information" /></h1>
		</div>
	</div>

	<div class="content">
    					<div class="table-style">
    						<div class="col width1-2 bg-red">
    							<div class="half-container-left">
    								<a href="/controller?command=dataCountOrder&page=notIdCountOrder.jsp">
    									<img src="https://pinkpointmedia.com/wp-content/uploads/2015/01/portfolio-icon.svg" alt="">
    									<h2><fmt:message key="count" /></h2>
    									<p><fmt:message key="count.info" /></p>
    								</a>
    							</div>
    						</div>

    						<div class="col width1-2 bg-blue">
    							<div class="half-container-right">
    								<a href="/controller?command=price&page=notIdPrice.jsp">
    									<img src="https://pinkpointmedia.com/wp-content/uploads/2015/01/results-icon.svg" alt="">
    									<h2><fmt:message key="indexAuthenticateUser.price" /></h2>
    									<p><fmt:message key="price.info" /></p>
    								</a>
    							</div>
    						</div>
    					</div>
    				</div>


	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	</body>
	</html>