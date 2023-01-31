<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Add Artist</title>

    <link rel="stylesheet" type="text/css" href="styles.css" />

</head>
<body>
<h1>Add/Edit Artist</h1>

<c:if test="${addArtistSuccess}">
    <div id="success">Successfully added Artist with Name: ${addArtistName}</div>
</c:if>

<form:form action="/artist" method="post" modelAttribute="artist">
    <form:errors path="*"  cssClass="errorblock" element="div/"/>
    <form:label path="id">ID: ${artist.id}</form:label><form:hidden path="id" />
    <form:label path="name" cssErrorClass="error">NAME:  </form:label> <form:input path="name" type="text" cssErrorClass="error"/>
    <form:label path="birthplace" cssErrorClass="error">BIRTHPLACE:  </form:label> <form:input path="birthplace" type="text" cssErrorClass="error"/>
    <form:label path="birth_year" cssErrorClass="error">BIRTH_YEAR:  </form:label> <form:input path="birth_year" type="text" cssErrorClass="error"/>
    <input id="submit" type="submit" value="submit">
</form:form>
</body>
</html>
