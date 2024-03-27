<%--
  Created by IntelliJ IDEA.
  User: Bap
  Date: 3/26/2024
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit account</title>
    <link rel="stylesheet" href="./asset/css/bootstrap.css">
    <link rel="stylesheet" href="./asset/css/editProductStyle.css">
</head>
<body>
<jsp:include page="./temp-decoration/header.jsp"></jsp:include>

<form action="#">
    <div class="container edit-form">
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Product name</label>
            <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Product name">
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Price</label>
            <input type="text" class="form-control" id="formGroupExampleInput2" placeholder="Price">
        </div>

        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Quantity</label>
            <input type="text" class="form-control" id="formGroupExampleInput3" placeholder="Quantity">
        </div>

        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Image</label>
            <input type="text" class="form-control" id="formGroupExampleInput4" placeholder="Image">
        </div>

        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Type</label>
            <input type="text" class="form-control" id="formGroupExampleInput5" placeholder="Type">
        </div>

        <div class="btn__container d-flex justify-content-center mt-3">
            <button type="submit" class="btn btn-primary">Sign in</button>
        </div>
    </div>
</form>

<jsp:include page="./temp-decoration/footer.jsp"></jsp:include>
</body>
<script src="./asset/js/bootstrap.bundle.js"></script>
</html>
