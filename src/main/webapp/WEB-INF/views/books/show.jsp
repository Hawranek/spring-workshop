<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 11.07.2021
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${book.title}</title>
</head>
<body>
<table border="1">
      <thead>
      <th>title</th>
      <th>isbn</th>
      <th>author</th>
      <th>publisher</th>
      <th>type</th>
      <th>action</th>
      </thead>
    <tbody>
    <td>
<%--        Tytuł:--%>
        <c:out value="${book.title}"/>
    </td>
    <td>
<%--        ISBN:--%>
        <c:out value="${book.isbn}"/>
    </td>
    <td>
<%--        Autor:--%>
        <c:out value="${book.author}"/>
    </td>
    <td>
<%--        Wydawca:--%>
        <c:out value="${book.publisher}"/>
    </td>
    <td>
<%--        Typ:--%>
        <c:out value="${book.type}"/>
    </td>
    <td>
        <a href="<c:out value="/admin/books/delete/${book.id}"/>">Usuń</a>
        <a href="<c:out value="/admin/books/edit/${book.id}"/>">Edytuj</a>
    </td>
    </tbody>
</table>
<a href="/admin/books/all">Wyswietl wszystkie książki</a><br/>

</body>
</html>
