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
                    <li><a href="/museum"> Museums</a></li>
                    <li><a href="/logout" class="button">
                        <button>Log out</button>
                    </a></li>
                </ul>
            </nav>
        </div>
        <div>
            <nav>
                <form style="margin-top: 13px" method="GET" action="searchArtist">
                    <input class="form-control" type="text" value="search" name="name">
                </form>
            </nav>
        </div>
    </div>
</header>
<h1 style="text-align: center">Artists</h1>


<div class="container">
    <div class="row">
        <c:forEach items="${artists}" var="artist">
            <div class="col">
                <img  src="images/${artist.name}.jpeg" alt="${artist.name}"><br>
                <a href="<c:url value = "/museumsByArtist">
                    <c:param name="id" value="${artist.id}" />
                    </c:url>"><div class="link-info">${artist.name}: Where can you see them?</div>
                </a><br>
            </div>

        </c:forEach>

    </div>
</div>

<table class="table table-dark">
    <thead>
    <tr>
        <th class="col" style="width: 60px">ID</th>
        <th class="col" style="width: 60px">NAME</th>
        <th class="col" style="width: 60px">BIRTH PLACE</th>
        <th class="col" style="width: 180px">BIRTH YEAR</th>
        <th class="col" style="width: 180px">PAINTINGS</th>
    </tr>
    </thead>
    <tbody>



    <c:forEach items="${artists}" var="artist">
        <tr>
            <th scope="row"><a href="
                   <c:url value = "/museum/edit">
                    <c:param name="id" value="${artist.id}" />
                    </c:url>
                    "
            >${artist.id}</a></th>
            <td>${artist.name}</td>
            <td>${artist.birthplace}</td>
            <td>${artist.birth_year}</td>
            <td><a href="
                          <c:url value = "paintingsByArtist">
                           <c:param name="id" value="${artist.id}" />
                           </c:url>
                           ">See their paintings</a>
        </tr>
    </c:forEach>


    </tbody>
    <br>


</table>
</body>
</html>




