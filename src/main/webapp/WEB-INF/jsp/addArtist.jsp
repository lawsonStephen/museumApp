<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Add Artist</title>

    <link rel="stylesheet" type="text/css" href="styles.css" />

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
<h1>Add/Edit Artist</h1>

<c:if test="${addArtistSuccess}">
    <div id="success">Successfully added Artist with Name: ${addArtistName}</div>
</c:if>

<form:form action="/artist" method="post" modelAttribute="artist">
    <form:errors path="*"  cssClass="errorblock" element="div/"/>
    <form:label path="id"> ${artist.id}</form:label><form:hidden path="id" />
    <form:label path="name" cssErrorClass="error">NAME:  </form:label> <form:input path="name" type="text" cssErrorClass="error"/>
    <form:label path="birthplace" cssErrorClass="error">BIRTHPLACE:  </form:label> <form:input path="birthplace" type="text" cssErrorClass="error"/>
    <form:label path="birth_year" cssErrorClass="error">BIRTH_YEAR:  </form:label> <form:input path="birth_year" type="text" cssErrorClass="error"/>
    <input id="submit" type="submit" value="submit">
</form:form>
</body>
</html>
