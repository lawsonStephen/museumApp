<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Add Sculpture</title>

    <link rel="stylesheet" type="text/css" href=styles.css />

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

<h1>Add/Edit Sculpture</h1>

<c:if test="${addSculptureSuccess}">
    <div id="success">Successfully added Sculpture with Name: ${addSculptureName}</div>
</c:if>

<form:form action="/sculpture" method="post" modelAttribute="sculpture">
    <form:errors path="*"  cssClass="errorblock" element="div/"/>
    <form:label path="id"> ${sculpture.id}</form:label><form:hidden path="id" />
    <form:label path="name" cssErrorClass="error">NAME:  </form:label> <form:input path="name" type="text" cssErrorClass="error"/>
    <form:label path="sculpture_year" cssErrorClass="error">SCULPTURE_YEAR:  </form:label> <form:input path="sculpture_year" type="text" cssErrorClass="error"/>
    <form:label path="sculpture_price" cssErrorClass="error">SCULPTURE_PRICE:  </form:label> <form:input path="sculpture_price" type="text" cssErrorClass="error"/>
    <form:select path="artist">
            <form:options items="${artistList}" itemLabel="name" itemValue="id"/>
    </form:select>
    <form:select path="museum">
                <form:options items="${museumList}" itemLabel="name" itemValue="id"/>
        </form:select>


    <input id="submit" type="submit" value="submit">
</form:form>
</body>
</html>
