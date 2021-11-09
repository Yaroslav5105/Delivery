<html>
<body>
<form name="loginForm" method="post" action="loginServlet">
    Username: <input type="text" name="name"/> <br/>
    Password: <input type="password" name="password"/> <br/>
    Number: <input type="number" name="number"/> <br/>
    Mail: <input type="mail" name="mail"/> <br/>
    <input type="submit" value="Login" />
</form>

    Feedback:<br/>
    <textarea rows="5" cols="30" name="feedback"></textarea>
<br/>
    Job Category:
    <select name="jobCat">
        <option value="tech">Technology</option>
        <option value="admin">Administration</option>
        <option value="biology">Biology</option>
        <option value="science">Science</option>
    </select>
    </form>
</body>
</html>