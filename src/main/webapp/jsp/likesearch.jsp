<%@ page import="com.etc.dao.impdetaildao" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ow200
  Date: 2021/9/3
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>serch</title>
    <script type="text/javascript" src="../js/jquery-3.6.0.js"></script>
</head>
<body>


<%
    impdetaildao impdetaildao = new impdetaildao();
    String[] split = new String[2];
    ArrayList alldetail = (ArrayList) session.getAttribute("likearry");
%>
<table>
    <thead>
    <tr>
        <th>userId</th>
        <th>username</th>
        <th>userPass</th>
    </tr>
    </thead>
    <tbody id="usetable">
    </tbody>
    <%
        for (int i = 0; i < alldetail.size(); i++) {
            split = alldetail.get(i).toString().split(",");
    %>
    <script>
        $("#usetable").append(
            "<tr><td><%=split[0]%></td><td><%=split[1]%></td><td><%=split[2]%>"
        )
    </script>
    <%
        }
    %>
</table>
</body>
</html>
