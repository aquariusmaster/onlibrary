<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--
  Created by IntelliJ IDEA.
  User: harkonnen
  Date: 18.03.16
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Saving book</title>
</head>
<body>
<sf:form method="post"
         action="${pageContext.request.contextPath}/docreate"
         commandName="book" enctype="multipart/form-data">
  <sf:input type="hidden" name="id" path="id" />

  <table class="formtable">
    <tr>
      <td class="label"><spring:message code="label.title" />:</td>
      <td><sf:textarea class="control" path="title" name="text"
                       rows="1" cols="100"></sf:textarea><br />
        <sf:errors path="title" cssClass="error"></sf:errors></td>
    </tr>
    <tr>
    <td class="label"><spring:message code="label.author" />:</td>
    <td><sf:textarea class="control" path="author" name="text"
                     rows="1" cols="100"></sf:textarea><br />
      <sf:errors path="author" cssClass="error"></sf:errors></td>
    </tr>

      <td class="label"><spring:message code="label.desc" />:</td>
      <td><sf:textarea class="control" path="description" name="text"
                       rows="4" cols="100"></sf:textarea><br />
          <sf:errors path="description" cssClass="error"></sf:errors></td>
      </tr>

    <tr>
      <td class="label"><spring:message code="label.genre" />:</td>
      <td><sf:select path="genre" items="${genre}"></sf:select><br />
        <sf:errors path="genre" cssClass="error"></sf:errors></td>
    </tr>
      <tr>
          <th><label for="file">File:</label></th>
          <td><input id="file" name="file" type="file"/>
      </tr>
    <tr>
      <td class="label"></td>
      <td><input class="control" value="Save" type="submit" /></td>
    </tr>

    <c:if test="${book.id != 0}">
      <tr>
        <td class="label"></td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td class="label"></td>
        <td><input class="delete control" name="delete" id="delete"
                   value="Delete this offer." type="submit" /></td>
      </tr>
    </c:if>
  </table>

</sf:form>
</body>
</html>
