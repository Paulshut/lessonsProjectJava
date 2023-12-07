<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>Create new user</head>
<body>
<form action="users/create" method="get">
    <input type="hidden" name="logan" value="${user.getLogin()}">
    <input type="hidden" name="password" value="${user.getPassword}">
</form>
<table>
    <thead>
    <tr>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
    </tr>
    </thead>
    <tbody>

    <form action="/users/create" method="post">
        <input type="hidden" name="logan" value="${param.login}">
        <input type="hidden" name="password" value="${param.password}">
        <td><input type="text" name="name" placeholder="put your name"></td>
        <td><input type="text" name="surname" placeholder="put your surname"></td>
        <td><input type="text" name="email" placeholder="put your email"></td>
        <td><input type="submit" value="create"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>