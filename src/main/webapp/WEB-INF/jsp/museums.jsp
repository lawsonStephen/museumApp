
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Museum</title>
</head>
<body>
<h1>Museums</h1>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>LOCATION</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${museums}" var="museum">
        <tr>
            <td><a href = "
                   <c:url value = "/museum/edit">
                    <c:param name="id" value="${museum.id}" />
                    </c:url>
                    "
            >${museum.id}</a>
            </td>
            <td>${museum.name}</td>
            <td>${museum.location}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>



