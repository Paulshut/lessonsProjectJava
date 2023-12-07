<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="cl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customers</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Contact phone</th>
    </tr>
    </thead>
    <tbody>
    <cl:forEach var="courier" items="${couriers}">
        <tr>
            <td>${courier.id}</td>
            <td>${courier.name}</td>
            <td>${courier.surname}</td>
            <td>${courier.contactPhone}</td>

            <td>
                <form action="/couriers/delete" method="post">
                    <input type="hidden" name="id" value="${courier.getId()}">
                    <input type="submit" value="Delete" style="float:left">
                </form>
            </td>
            <td>
                <form action="/couriers/update" method="get">
                    <input type="hidden" name="id" value="${courier.getId()}">
                    <input type="hidden" name="name" value="${courier.getName()}">
                    <input type="hidden" name="surname" value="${courier.getSurname()}">
                    <input type="hidden" name="contactPhone" value="${courier.getContactPhone()}">
                    <input type="submit" value="Update" style="float:left">
                </form>
            </td>
        </tr>
    </cl:forEach>
    </tbody>
</table>
<form action="/couriers/create" method="get">
    <input type="submit" value="Create new courier">
</form>
<form action="/users/menu" method="get">
    <input type="submit" value="back">
</form>
</body>
</html>