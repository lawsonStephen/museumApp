
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href=styles.css>
    <title>Painting</title>
</head>
<body>

<header class="header_main">
    <div class="header_menu">
        <%--<div class="logo">
            <a href="index.html"><img src="images/logo-header.svg" alt="logotype"></a>
        </div>--%>
        <div class="nav_container">
            <nav>
                <ul class="menu">
                    <li><a href="/">Home</a></li>
                    <li><a href="/painting">Paintings</a></li>
                    <li><a href="/artist">Artists</a></li>
                    <li><a href="/sculpture">Sculptures</a></li>
                </ul>
            </nav>
        </div>
        <div class="nav_sign">
            <nav>
                <ul class="menu">
                    <li><a href="/museum">Museums</a></li>
                    <li><a href="/logout" class="button">
                        <button>Log out</button>
                    </a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>
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



