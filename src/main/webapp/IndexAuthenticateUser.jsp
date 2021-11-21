 <html>
 <body>
 <form name="countOrder.jsp" method="get" action="CountOrderServlet">
 <input type="submit" value="count order" />
 </form>

 <form name="price.jsp" method="get" action="ViewPriceUserServlet">
  <input type="submit" value="price and way" />
  </form>

  <form name="userListOrder.jsp" method="get" action="UserListOrderServlet">
    <input type="hidden" name="userId" value="${user.id}"/>
    <input type="submit" value="pay" />
    </form>

    <form name="addOrderForUser.jsp" method="get" action="AddOrderForUserServlet">
         <input type="hidden" name="userId" value="${user.id}"/>
        <input type="submit" value="Order" />


</form>
 </body>
 </html>