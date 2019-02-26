<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vardan
  Date: 26.02.2019
  Time: 4:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/admin/addKino" method="post" enctype="multipart/form-data">
    Name: <input type="text" name="name"><br>
    Description: <input type="text" name="description"><br>
    Image: <input type="file" name="picture"><br>
    Year: <input type="text" name="year"><br>
    Director: <input type="text" name="directorName"><br>
    SelectGenre: <C:forEach var="genre" items="${allGenres}"><br>
    ${genre.name} <input type="checkbox" value="${genre.name}" name="genre">
</C:forEach>

    <input type="submit" value="AddKino">
</form>

<form action="/admin/addGenre">
    Name: <input type="text" name="name"><br>
    <input type="submit" value="addGenre">
</form>
</body>
</html>
