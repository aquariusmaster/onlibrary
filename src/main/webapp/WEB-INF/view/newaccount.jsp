<%--
  Created by IntelliJ IDEA.
  User: harkonnen
  Date: 21.03.16
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title></title>
</head>
<body>
<h2>Create New Account</h2>

<sf:form id="details" method="post"
         action="${pageContext.request.contextPath}/createaccount"
         commandName="user">

  <table class="formtable">
    <tr>
      <td class="label">Username:</td>
      <td><sf:input class="control" path="username" name="username"
                    type="text" /><br />
        <div class="error">
          <sf:errors path="username"></sf:errors>
        </div></td>
    </tr>
    <tr>
      <td class="label">Name:</td>
      <td><sf:input class="control" path="name" name="name"
                    type="text" /><br />
        <div class="error">
          <sf:errors path="name"></sf:errors>
        </div></td>
    </tr>
    <tr>
      <td class="label">Email:</td>
      <td><sf:input class="control" path="email" name="email"
                    type="text" />
        <div class="error">
          <sf:errors path="email"></sf:errors>
        </div></td>
    </tr>
    <tr>
      <td class="label">Password:</td>
      <td><sf:input id="password" class="control" path="password"
                    name="password" type="password" />
        <div class="error">
          <sf:errors path="password"></sf:errors>
        </div></td>
    </tr>
    <tr>
      <td class="label">Confirm Password:</td>
      <td><input id="confirmpass" class="control" name="confirmpass"
                 type="password" />
        <div id="matchpass"></div></td>
    </tr>
    <tr>
      <td class="label"></td>
      <td><input class="control" value="Create account" type="submit" /></td>
    </tr>
  </table>

</sf:form>
</body>
</html>
