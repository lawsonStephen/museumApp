
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href=styles.css>
    <title>Sculpture</title>
</head>
<body>
<h1>Sculptures</h1>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>SCULPTURE_YEAR</th>
        <th>SCULPTURE_PRICE</th>
        <th>ARTIST</th>
        <th>MUSEUM</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sculptures}" var="sculpture">
        <tr>
            <td><a href = "
                   <c:url value = "/sculpture/edit">
                    <c:param name="id" value="${sculpture.id}" />
                    </c:url>
                    "
            >${sculpture.id}</a>
            </td>
            <td>${sculpture.name}</td>
            <td>${sculpture.sculpture_year}</td>
            <td>${sculpture.sculpture_price}</td>
            <td>${sculpture.artist.name}</td>
            <td>${sculpture.museum.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>



