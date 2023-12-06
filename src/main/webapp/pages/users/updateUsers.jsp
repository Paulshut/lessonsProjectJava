<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>Update User</head>
<body>
<table>
    <thead>
    <tr>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
    </tr>
    </thead>
    <tbody>
    <form action="/users/update" method="post">
        <tr>
            <input type="hidden" name="id" value="${param.id}">
            <td><input type="text" name="name" value="${param.name}" placeholder=${param.name}></td>
            <td><input type="text" name="surname" value="${param.surname}" placeholder=${param.surname}></td>
            <td><input type="text" name="email" value="${param.email}" placeholder=${param.email}></td>
            <td><input type="submit" value="Update"></td>
        </tr>
    </form>
    </tbody>
</table>
<form action="/users/read" method="get">
    <input type="submit" value="Back">
</form>
</body>
</html>