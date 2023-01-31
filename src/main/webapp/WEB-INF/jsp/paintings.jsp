
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Painting</title>
</head>
<body>
<h1>Paintings</h1>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PAINTING_YEAR</th>
        <th>PAINTING_PRICE</th>
        <th>ARTIST</th>
        <th>MUSEUM</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${paintings}" var="painting">
        <tr>
            <td><a href = "
                   <c:url value = "/painting/edit">
                    <c:param name="id" value="${painting.id}" />
                    </c:url>
                    "
            >${painting.id}</a>
            </td>
            <td>${painting.name}</td>
            <td>${painting.painting_year}</td>
            <td>${painting.painting_price}</td>
            <td>${painting.artist.name}</td>
            <td>${painting.museum.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>



