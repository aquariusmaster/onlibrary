<%--
  Created by IntelliJ IDEA.
  User: harkonnen
  Date: 21.03.16
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Login</title>
</head>
<body>

<script type="text/javascript">
  $(document).ready(function() {
    document.f.j_username.focus();
  });
</script>

<h3>Login with Username and Password</h3>

<c:if test="${param.error != null}">

  <p class="error">Login failed. Check that your username and
    password are correct.</p>

</c:if>


<form name='f'
      action='<c:url value="/j_spring_security_check"></c:url>'
      method='POST'>
  <table class="formtable">
    <tr>
      <td>User:</td>
      <td><input type='text' name='j_username' value=''></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type='password' name='j_password' /></td>
    </tr>
    <tr>
      <td>Remember me:</td>
      <td><input type='checkbox' name='_spring_security_remember_me'
                 checked="checked" /></td>
    </tr>
    <tr>
      <td colspan='2'><input name="submit" type="submit" value="Login" /></td>
    </tr>
      <input type="hidden"
             name="${_csrf.parameterName}"
             value="${_csrf.token}"/>
  </table>
</form>

<p>
  <a href="<c:url value="/newaccount"/>">Create new account</a>
</p>

</body>
</html>
