<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <title>Add Museum</title>

    <link rel="stylesheet" type="text/css" href="styles.css" />

</head>
<body>
<h1>Add/Edit Museum</h1>

<c:if test="${addMuseumSuccess}">
    <div>Successfully added Museum with Name: ${addMuseumName}</div>
</c:if>

<form:form action="/museum" method="post" modelAttribute="museum">
    <form:errors path="*"  cssClass="errorblock" element="div/"/>
    <form:label path="id">ID: ${museum.id}</form:label><form:hidden path="id" />
    <form:label path="name" cssErrorClass="error">NAME:  </form:label> <form:input path="name" type="text" cssErrorClass="error"/>
    <form:label path="location" cssErrorClass="error">LOCATION:  </form:label> <form:input path="location" type="text" cssErrorClass="error"/>
    <input type="submit" value="submit">
</form:form>
</body>
</html>
