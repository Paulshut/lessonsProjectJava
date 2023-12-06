<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
Welcome to sdsDelivery
</head>
<body>
<table>
    <thead>
    <tr>
        <th>login</th>
        <th>password</th>
    </tr>
    </thead>
    <tbody>
    <form action="/users/authentication" method="post">
        <tr>
            <td><input type="text" name="login" placeholder="put your login"></td>
            <td><input type="text" name="password" placeholder="put your password"></td>
            <td><input type="submit" value="Sing in"></td>
        </tr>
    </form>
    </tbody>
</table>
<form action="/users/registration" method="get" >
    <tr>
        <td><input type="submit" value="Registration"></td>
    </tr>
</form>
</body>
</html>