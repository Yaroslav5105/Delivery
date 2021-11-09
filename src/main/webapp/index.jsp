<html>
<body>
<form name="loginForm" method="post" action="loginServlet">
    Username: <input type="text" name="name"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    Number: <input type="number" name="number"/> <br/>
    Mail: <input type="mail" name="mail"/> <br/>
    <input type="submit" value="Login" />
</form>

<br/>

    <form name="MyServlet" method="post" action="MyServlet">
        delete: <input type="delete" name="delete"/>
        <input type="submit" value="delete" />
    </form>

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
</body>
</html>