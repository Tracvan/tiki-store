<%--
  Created by IntelliJ IDEA.
  User: Bap
  Date: 3/26/2024
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>

<link rel="stylesheet" href="../asset/css/authStyle.css">

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand temp-logo" href="/webapp">CGSG SHOP</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/webapp">Home</a>
                </li>
            </ul>
            <form class="d-flex" role="search" action="#">
                <input class="search__input form-control me-2" type="search" placeholder="Search"
                       aria-label="Search">
                <button class="search__btn btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
