<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: harkonnen
  Date: 17.03.16
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Online Library</title>
</head>
<body>



<p>Search:</p>
<hr>
<div>

  <h2 align="center">Books list</h2>

  <ol type="1">

  <c:forEach var="book" items="${booksList}">

      <li><a href="<c:url value="/book/${book.id}"/>">${book.title} ${book.author}</a></li>

  </c:forEach>

  </ol>
</div>

</body>
</html>
