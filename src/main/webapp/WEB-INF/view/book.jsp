<%--
  Created by IntelliJ IDEA.
  User: harkonnen
  Date: 17.03.16
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Book ${book.title}</title>
</head>
<body>
<h2>Book ${book.id}</h2>
<div>
  <p><strong><spring:message code="label.title" />: </strong> ${book.title}</p>
  <p><strong><spring:message code="label.author" />: </strong> ${book.author}</p>
  <p><strong><spring:message code="label.genre" />: </strong> ${book.genre}</p>
  <p><strong><spring:message code="label.desc" />: </strong> ${book.description}</p>
  <p><strong>Download: </strong> <a href="<c:url value="/get/${book.filename}"/>">Link</a> </p>

</div>
</body>
</html>
