<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Add Painting</title>

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
<h1>Add/Edit Painting</h1>

<c:if test="${addPaintingSuccess}">
    <div>Successfully added Painting with Name: ${addPaintingName}</div>
</c:if>

<form:form action="/painting" method="post" modelAttribute="painting">
    <form:errors path="*"  cssClass="errorblock" element="div/"/>
    <form:label path="id">ID: ${museum.id}</form:label><form:hidden path="id" />
    <form:label path="name" cssErrorClass="error">NAME:  </form:label> <form:input path="name" type="text" cssErrorClass="error"/>
    <form:label path="painting_year" cssErrorClass="error">PAINTING_YEAR:  </form:label> <form:input path="painting_year" type="text" cssErrorClass="error"/>
    <form:label path="painting_price" cssErrorClass="error">PAINTING_PRICE:  </form:label> <form:input path="painting_price" type="text" cssErrorClass="error"/>
    <form:select path="artist">
            <form:options items="${artistList}" itemLabel="name" itemValue="id"/>
    </form:select>
    <form:select path="museum">
                <form:options items="${museumList}" itemLabel="name" itemValue="id"/>
        </form:select>


    <input type="submit" value="submit">
</form:form>
</body>
</html>
