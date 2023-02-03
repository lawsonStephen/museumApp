<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href=/src/main/resources/static/styles.css>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Artist</title>

    <style>

        img {
            width: 320px;
            height: 160px;
            opacity: 0.8;
            border-radius: 30px;
        }

    </style>
</head>
<body>
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

<h1>Add/Edit Artist</h1>

<c:if test="${addArtistSuccess}">
    <div id="success">Successfully added Artist with Name: ${addArtistName}</div>
</c:if>

<form:form action="/artist" method="post" modelAttribute="artist">
    <form:hidden path="artistUrl"/>
    <form:errors path="*"  cssClass="errorblock" element="div/"/>
    <form:label path="id"> ${artist.id}</form:label><form:hidden path="id" />
    <form:label path="name" cssErrorClass="error">NAME:  </form:label> <form:input path="name" type="text" cssErrorClass="error"/>
    <form:label path="birthplace" cssErrorClass="error">BIRTHPLACE:  </form:label> <form:input path="birthplace" type="text" cssErrorClass="error"/>
    <form:label path="birth_year" cssErrorClass="error">BIRTH_YEAR:  </form:label> <form:input path="birth_year" type="text" cssErrorClass="error"/>
    <input id="submit" type="submit" value="submit">
</form:form>
</body>
</html>
