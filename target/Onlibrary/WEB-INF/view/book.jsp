<%--
  Created by IntelliJ IDEA.
  User: harkonnen
  Date: 17.03.16
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Book</title>
</head>
<body>
<h2>This is your book</h2>
<div>
  <p><strong>Title: </strong> ${book.title}</p>
  <p><strong>Author: </strong> ${book.author}</p>
  <p><strong>Genre: </strong> ${book.genre}</p>
  <p><strong>Download: </strong> <a href="<c:url value="/get/${book.filename}"/>">Link</a> </p>

</div>
</body>
</html>
