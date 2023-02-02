<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href=styles.css>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Sculpture</title>
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
    <h1>Sculpture</h1>

    <div class="topnav">
        <p><strong>Please feel free to enjoy and discover more about these <u>precious and wonderful</u>
            sculptures:</strong></p>
        <div class="search-container">
            <form style="margin-top: 13px" method="GET" action="searchSculpture">
                <input style="width: 300px" class="form-control" type="text" placeholder="Search.." name="name">
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>

    <div class="horizontal-scroll-wrapper squares">
        <c:forEach items="${sculptures}" var="sculpture">
            <div class="painting">
                <div class="left">
                    <img src="${sculpture.imagePath}" alt="sculpture images" sizes=""></div>
                <div class="right">
                    <h2>${sculpture.name}</h2>
                    <h4>${sculpture.artist.name}</h4>
                    <p>Description here jkadsfjasfnandfc fqehfquafgweaf qfefqefwefg qfgwqmqoqirb agegsegswh</p>
                    <a href="https://www.louvre.fr/en/">Link</a>
                </div>
            </div>
        </c:forEach>
    </div>
    <table class="table table-dark" style="background-color: #172755">
        <thead>
        <tr>
            <th class="col" style="width: 60px">ID</th>
            <th class="col" style="width: 60px">NAME</th>
            <th class="col" style="width: 60px">SCULPTURE_YEAR</th>
            <th class="col" style="width: 60px">SCULPTURE_PRICE</th>
            <th class="col" style="width: 60px">ARTIST</th>
            <th class="col" style="width: 60px">MUSEUM</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sculptures}" var="sculpture">
            <tr>
                <th scope="row"><a href="
                   <c:url value = "/sculpture/edit">
                    <c:param name="id" value="${sculpture.id}" />
                    </c:url>
                    "
                >${sculpture.id}</a>
                </th>
                <td>${sculpture.name}</td>
                <td>${sculpture.sculpture_year}</td>
                <td>${sculpture.sculpture_price}</td>
                <td>${sculpture.artist.name}</td>
                <td>${sculpture.museum.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
</body>
</html>



