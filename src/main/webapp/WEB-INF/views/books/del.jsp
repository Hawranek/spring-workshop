<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 11.07.2021
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${book.title}</title>
</head>
<body>
<form method="post">
    Czy jesteś pewien, że chcesz usunąć tę książkę?
    <jsp:include page="show.jsp"/>
    <input type="submit" value="Potwierdź">
</form>
</body>
</html>
