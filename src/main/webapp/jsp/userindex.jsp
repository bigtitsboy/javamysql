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
    <title>allusers</title>
    <script type="text/javascript" src="../js/jquery-3.6.0.js"></script>
</head>
<body>
<table>
    <tbody>
    <tr>
        <td>
            <input id="likesearch" type="text" value="">
        </td>
        <td>
            <button onclick="likesearch()">search</button>
        </td>
    </tr>
    </tbody>
</table>
<script>
    function likesearch() {
        // console.log($('#likesearch').val())
        window.location.href='/LikeServlet?val='+$('#likesearch').val()
    }
</script>
<%
    impdetaildao impdetaildao = new impdetaildao();
    String[] split = new String[2];
    ArrayList alldetail = impdetaildao.alldetail();
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
            +
            "</td><td><a href=\"/DelServlet?id=<%=split[0]%>\">del</a></td><td><button onclick='update(<%=split[0]%>,<%=split[1]%>,<%=split[2]%>,<%=split[0]%>)'>update</button></td></tr>"
        )
    </script>
    <%
        }
    %>
</table>
<a href=""></a>
<h1>add user</h1>
<button>
    <a href="http://localhost:8080/jsp/adduser.jsp">
        now add
    </a>
</button>
<div id="bottomdiv" style="margin-top: 50px"></div>
<script>
    function update(id, name, pwd, oldid) {
        $('#bottomdiv').append(
            "<form action=\"/EditServlet\" method=\"post\">" +
            "<table style=\"float: left\">"
            + "<thead>" +
            "<tr>" +
            "<th>userId</th>" +
            "<th>username</th>" +
            "<th>userPass</th>" +
            "<th>oldvalue</th>" +
            "</tr>" +
            "</thead>" +
            "<tbody>" +
            " <tr>" +
            "<td><input name='id' type=\"text\" value=" + id + "></td>" +
            "<td><input name='uname' type=\"text\" value=" + name + "></td>" +
            "<td><input name='userPass' type=\"text\" value=" + pwd + "></td>" +
            "<td><input readonly='readonly' name='oldid' type=\"text\" value=" + oldid + "></td>" +
            "</tr>" +
            "</tbody>" +
            "</table>" +
            "<input type=\"submit\" value=\"submit\">" +
            "</form>"
        )
    }
</script>
</body>
</html>
