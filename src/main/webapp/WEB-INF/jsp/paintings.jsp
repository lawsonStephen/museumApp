<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href=styles.css>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Painting</title>
</head>
<header class="header_main">
    <div class="header_menu">
        <div class="nav_container">
            <nav>
                <ul class="menu">
                    <li><a href="/">Home</a></li>
                    <li><a href="/museum">Museums</a></li>
                    <li><a href="/artist">Artists</a></li>
                    <li><a href="/painting">Paintings</a></li>
                    <li><a href="/sculpture">Sculptures</a></li>
                </ul>
            </nav>
        </div>
        <div class="nav_sign">
            <nav>
                <ul class="menu">
                    <li><a href="/exchange">Exchange Art</a></li>
                    <li><a href="/logout" class="button">
                        <button>Log out</button>
                    </a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>

<body>

<main class="paintings_main">
    <h1>Paintings</h1>

    <div class="topnav">
        <p><strong>Please feel free to enjoy and discover more about these <u>precious and wonderful</u>
            paintings:</strong></p>
        <div class="search-container">
            <form style="margin-top: 13px" method="GET" action="searchPainting">
                <input style="width: 300px" class="form-control" type="text" placeholder="Search.." name="name">
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>

    <div class="horizontal-scroll-wrapper squares">
        <c:forEach items="${paintings}" var="painting">
            <div class="painting">
                <div class="left">
                    <img src="${painting.imagePath}" alt="paintings images" sizes=""></div>
                <div class="right">
                    <h2>${painting.name}</h2>
                    <h4>By ${painting.artist.name}</h4>
                    <p>${painting.description}</p>
                    <a href="${painting.link}">More in Wikipedia</a>
                </div>
            </div>
        </c:forEach>
    </div>

    <table class="table table-dark" style="background-color: #172755">
        <thead>
        <tr>
            <th class="col" style="width: 60px">ID</th>
            <th class="col" style="width: 60px">NAME</th>
            <th class="col" style="width: 60px">PAINTING_YEAR</th>
            <th class="col" style="width: 60px">PAINTING_PRICE</th>
            <th class="col" style="width: 60px">ARTIST</th>
            <th class="col" style="width: 60px">MUSEUM</th>
            <th class="col" style="width: 60px">IMAGE</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${paintings}" var="painting">
            <tr>
                <th scope="row"><a href="
                   <c:url value = "/painting/edit">
                    <c:param name="id" value="${painting.id}" />
                    </c:url>
                    "
                >${painting.id}</a>
                </th>
                <td>${painting.name}</td>
                <td>${painting.painting_year}</td>
                <td>${painting.painting_price}</td>
                <td>${painting.artist.name}</td>
                <td>${painting.museum.name}</td>
                <td><img src="${painting.imagePath}" width="40" height="40"</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
</body>
</html>