
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href=styles.css>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Artist</title>
</head>
<body>
<h1>Artists</h1>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>BIRTHPLACE</th>
        <th>BIRTH_YEAR</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${artists}" var="artist">
        <tr>
            <td><a href = "
                   <c:url value = "/artist/edit">
                    <c:param name="id" value="${artist.id}" />
                    </c:url>
                    "
            >${artist.id}</a>
            </td>
            <td>${artist.name}</td>
            <td>${artist.birthplace}</td>
            <td>${artist.birth_year}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>



