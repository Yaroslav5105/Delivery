<html>
<body>
    <form name="OrderServlet" method="post" action="OrderServlet">
        idUser: <input type="idUser" name="idUser"/> <br/>
        idRoute:
            <select name="idRoute">
                <option value="150">Kharkiv - Poltava</option>
                <option value="700">Kharkiv - Lviv</option>
                <option value="500">Kharkiv - Kuev</option>
                <option value="350">Kharkiv - Dnepr </option>
            </select>
            <br/>
        volume: <input type="volume" name="volume"/> <br/>
        weight: <input type="weight" name="weight"/> <br/>
        <input type="submit" value="order" />
        <br/><br/>
    </form>
    <form name="DeleteOrderServlet" method="post" action="DeleteOrderServlet">
                    delete Order: <input type="deleteorder" name="deleteorder"/>
                    <input type="submit" value="deleter" />
    </form>

    <form name="AuthenticateServlet" method="post" action="AuthenticateServlet">
                        email: <input type="email" name="email"/>
                        password: <input type="password" name="password"/>
                        <input type="submit" value="Authenticate" />
        </form>

        <form name="managerListUser.jsp" method="post" action="managerListUser.jsp">
                <input type="submit" value="managerListUser" />
            </form>
</body>
</html>