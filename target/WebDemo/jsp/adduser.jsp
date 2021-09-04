<%--
  Created by IntelliJ IDEA.
  User: ow200
  Date: 2021/9/4
  Time: 0:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>adduser</title>
</head>
<body>
<form action="/AddServlet" method="post">
    <table>
        <thead>
        <tr>
            <th>userId</th>
            <th>username</th>
            <th>userPass</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>
                <input type="text" name="id">
            </td>
            <td>
                <input type="text" name="uname">
            </td>
            <td>
                <input type="password" name="userPass">
            </td>
        </tr>
        </tbody>
    </table>
    <input type="submit">
</form>
</body>
</html>
