<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href=styles.css>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Painting by ${name}</title>
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

<main class="paintings_main" style="text-align: unset">
    <h1>Paintings by ${name}</h1>

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

    <div class="horizontal-scroll-wrapper squares" style="">
        <c:forEach items="${wikiPaintings}" var="painting">
            <div class="painting" style="display: inline-block">
                <div class="right" style="padding-top: 0px; padding-left: 0px">
                    <h4 style="padding-top: 0px; padding-left: 0px">${painting.title}</h4>
                    <h5>${painting.artistName}</h5>
                </div>
                <div class="left">
                    <img src="${painting.image}" alt="paintings images" sizes="">
                </div>
            </div>
        </c:forEach>
    </div>

    <table class="table table-dark">
        <thead>
        <tr>
            <th class="col" style="width: 80px">NAME</th>
            <th class="col" style="width: 80px">PAINTING_YEAR</th>
            <th class="col" style="width: 80px">ARTIST</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${wikiPaintings}" var="painting">
            <tr>
                <td>${painting.title}</td>
                <td>${painting.completitionYear}</td>
                <td>${painting.artistName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
</body>
</html>