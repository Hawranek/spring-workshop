<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: damian
  Date: 11.07.2021
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding Book</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<table border="1">
    <%--  <thead>--%>
    <%--  <th>isbn</th>--%>
    <%--  <th>title</th>--%>
    <%--  <th>author</th>--%>
    <%--  </thead>--%>
    <tbody>
    <form:form modelAttribute="book" method="post">
        <form:hidden path="id"/>
        <tr>
            Tytuł:
            <form:input path="title"/>
            <form:errors path="title" cssClass="error"/>
            <br/>
        </tr>
        <tr>
            ISBN:
            <form:input path="isbn"/>
            <form:errors path="isbn" cssClass="error"/>
            <br/>
        </tr>
        <tr>
            Autor:
            <form:input path="author"/>
            <form:errors path="author" cssClass="error"/>
            <br/>
        </tr>
        <tr>
            Wydawca:
            <form:input path="publisher"/>
            <form:errors path="publisher" cssClass="error"/>
            <br/>
        </tr>
        <tr>
            Typ:
            <form:input path="type"/>
            <form:errors path="type" cssClass="error"/>
            <br/>
        </tr>
    <input type="submit">
    </form:form>

    </tbody>
</table>
<a href="/admin/books/all">Wyswietl wszystkie książki</a><br/>

</body>
</html>
