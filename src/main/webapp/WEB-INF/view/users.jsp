<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: harkonnen
  Date: 17.03.16
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<table class="users">
  <tr>
    <td>Username</td>
    <td>Pass</td>
    <td>Email</td>
    <td>Set</td>
  </tr>

  <c:forEach var="user" items="${usersList}">
    <tr>

      <td><c:out value="${user.username}"></c:out></td>

      <td><c:out value="${user.password}"></c:out></td>

      <td><c:out value="${user.email}"></c:out></td>

      <td><c:out value="${user.favBooks}"></c:out></td>

    </tr>
  </c:forEach>
</table>

</body>
</html>
