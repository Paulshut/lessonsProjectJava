<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    Sing Up
</head>
<body>
<table>
    <tbody>
    <form action="/users/dataUsers" method="post">
        <tr>
            <td><input type="text" name="login" placeholder="put your login"></td>
        </tr>
        <tr>
            <td><input type="text" name="password" placeholder="put your password"></td>
        </tr>
        </tr>
        <td><input type="submit" value="Sing Up"></td>
        </tr>
        </tr>
    </form>
    <form action="/pages/users/index.jsp">
        <td><input type="submit" value="back"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>