<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    Add parcels
</head>
<body>
<table>
    <thead>
    <tr>
        <th>sender name</th>
        <th>receive name</th>
    </tr>
    </thead>
    <tbody>
    <form action="/parcels/create" method="post">
        <tr>
            <input type="hidden" name="id" value="${param.id}">
            <td><input type="text" name="senderName" placeholder="put your sender name"></td>
            <td><input type="text" name="receiveName" placeholder="put your receive name"></td>
            <td><input type="submit" value="create"></td>
        </tr>
    </form>
    </tbody>
</table>
<form action="/users/menu" method="get">
<input type="submit" value="back">
</form>
</body>
</html>
