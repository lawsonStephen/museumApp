<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href=styles.css>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Museum</title>

    <style>

        img {
            width: 320px;
            height: 160px;
            opacity: 0.8;
            border-radius: 30px;
        }


    </style>
</head>
<body style="background-color: burlywood">
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
                    <li><a href="/exchange">Exchange Artifact</a></li>
                    <li><a href="/logout" class="button">
                        <button>Log out</button>
                    </a></li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<div class="container">
    <h1 style="padding-top: 60px;">Museums</h1>
    <div class="topnav">
        <p><strong>Search your favourite museums and buy as many tickets as you would like:</strong></p>
        <div class="search-container">
            <form style="margin-top: 13px" method="GET" action="searchMuseum">
                <input style="width: 300px" class="form-control" type="text" placeholder="Search.." name="name">
                <button type="submit">Submit</button>
            </form>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <c:forEach items="${museums}" var="museum">
            <div class="col">
                <img src="${museum.imagePath}" alt="${museum.name}"><br>
                <a href="
                           <c:url value = "/tickets">
                               <c:param name="id" value="${museum.id}" />
                           </c:url>
                           ">
                    <div class="link-info">${museum.name}: Buy Tickets</div>
                </a><br>
            </div>

        </c:forEach>

    </div>
</div>

<table class="table table-dark" style="background-color: #172755">
    <thead>
    <tr>
        <th class="col" style="width: 60px">ID</th>
        <th class="col" style="width: 60px">NAME</th>
        <th class="col" style="width: 60px">LOCATION</th>
        <th class="col" style="width: 180px">DESCRIPTION</th>
        <th class="col" style="width: 60px">LINK</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach items="${museums}" var="museum">
        <tr>
            <th scope="row"><a href="
                   <c:url value = "/museum/edit">
                    <c:param name="id" value="${museum.id}" />
                    </c:url>
                    "
            >${museum.id}</a></th>
            <td>${museum.name}</td>
            <td>${museum.location}</td>
            <td>"The Louvre, or the Louvre Museum, is the world's most-visited museum, and a historic landmark in Paris,
                France. It is the home of some of the best-known works of art, including the Mona Lisa and the Venus de
                Milo." - Wikipedia
            </td>
            <td><a href="https://www.louvre.fr/en">Link to the website</a></td>
        </tr>
    </c:forEach>


    </tbody>
    <br>


</table>
</body>
</html>



