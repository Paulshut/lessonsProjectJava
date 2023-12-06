<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>

            <td>
                <form action="/users/delete" method="post">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="submit" value="Delete" style="float:left">
                </form>
            </td>
            <td>
                <form action="/users/update" method="get">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="hidden" name="name" value="${user.getName()}">
                    <input type="hidden" name="surname" value="${user.getSurname()}">
                    <input type="hidden" name="email" value="${user.getEmail()}">
                    <input type="submit" value="Update" style="float:left">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/users/menu" method="get">
    <input type="submit" value="Back">
</form>
</body>
</html>