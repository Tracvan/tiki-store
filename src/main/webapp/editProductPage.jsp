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

<form action="${pageContext.request.contextPath}/webapp?action=edit" method="post">
    <div class="container edit-form">
        <input type="hidden" hidden="hidden" name="productId" value="${product.productId}">
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Product name</label>
            <input type="text" name="name" class="form-control" id="formGroupExampleInput"
                   value="${product.productName}">
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Price</label>
            <input type="text" name="price" class="form-control" id="formGroupExampleInput2" value="${product.price}">
        </div>

        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Quantity</label>
            <input type="text" name="quantity" class="form-control" id="formGroupExampleInput3"
                   value="${product.quantity}">
        </div>

        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Type</label>
            <input type="text" name="type" class="form-control" id="formGroupExampleInput4" value="${product.type}">
        </div>

        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Image</label>
            <input type="text" name="image" class="form-control" id="formGroupExampleInput5" value="${product.image}">
        </div>

        <div class="btn__container d-flex justify-content-center mt-3">
            <button type="submit" class="btn btn-primary">Save change</button>
        </div>
    </div>
</form>

<jsp:include page="./temp-decoration/footer.jsp"></jsp:include>
</body>
<script src="./asset/js/bootstrap.bundle.js"></script>
</html>
