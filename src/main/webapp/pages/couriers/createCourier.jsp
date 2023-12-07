
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   Create new courier
</head>
<body>
<table>
    <thead>
    <tr>
        <th>name</th>
        <th>surname</th>
        <th>Contact Phone</th>
    </tr>
    </thead>
    <tbody>

    <form action="/couriers/create" method="post">
        <td><input type="text" name="name" placeholder="put your name"></td>
        <td><input type="text" name="surname" placeholder="put your surname"></td>
        <td><input type="text" name="contactPhone" placeholder="put your contact phone"></td>
        <td><input type="submit" value="create"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>