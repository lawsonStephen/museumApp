<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href=styles.css>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Purchase Your Museum Tickets</title>

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
                <form style="margin-top: 13px" method="GET" action="searchMuseum">
                    <input class="form-control" type="text" value="search" name="name">
                </form>
            </nav>
        </div>
    </div>
</header>
<h1><center><font color="#00008b"> Buy your Museum Ticket for <b>${museum.location}, ${museum.name}</b> now!</font></center></h1>
<h4><center><font color="#00008b"> Don't miss out on your tickets today</font></center></h4>
<h5></h5>

<div class="col"><center>
    <img  src="${museum.imagePath}" alt="${museum.name}"><br></center>
    <div class="link-info"></div></a><br>
</div>

<c:if test="${addTicketSuccess}">
    <div><b><font color="#f0ffff"><center> 🎉 Congratulations! 🎉 You have bought ${addTicketNumber} tickets for:<font color="#00008b"> ${addMuseumName}, ${addMuseumLocation}</font></center></font></b></div>
</c:if>

<form:form action="/tickets" method="post" modelAttribute="museum">
    <form:errors path="*"  cssClass="errorblock" element="div/"/><center>
    <form:label path="id"><b><font color="#f0ffff"> 🏷️ ID: </font>${museum.id}</b></form:label><form:hidden path="id"/>
    <form:label path="location" cssErrorClass="error"><b><font color="#f0ffff">     🏛️ NAME:</font></b>  </form:label> <form:input path="location" type="text" cssErrorClass="error"/>
    <form:label path="name" cssErrorClass="error"><b><font color="#f0ffff"> 📍 LOCATION: </font></b> </form:label> <form:input path="name" type="text" cssErrorClass="error"/>
    <form:label path=""><b><font color="#f0ffff">  🎫 QUANTITY: </font></b></form:label>
    <form:hidden path="imagePath"/>
    <form:select path="availableQuantity">
        <form:option value="1" label="1"/>
        <form:option value="2" label="2"/>
        <form:option value="3" label="3"/>
        <form:option value="4" label="4"/>
        <form:option value="5" label="5"/>
        <form:option value="6" label="6"/>
        <form:option value="7" label="7"/>
        <form:option value="8" label="8"/>
        <form:option value="9" label="9"/>
        <form:option value="10" label="10"/>
    </form:select>
    <input class="buton" type="submit" value="submit"></center>
</form:form>
</body>
</html>