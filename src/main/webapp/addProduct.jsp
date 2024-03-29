<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" href="./asset/css/bootstrap.css">
    <link rel="stylesheet" href="./asset/css/editProductStyle.css">
</head>
<body>
<jsp:include page="./temp-decoration/header.jsp"></jsp:include>

<form action="/webapp?action=create" method="post">
    <div class="container edit-form">
        <div class="mb-3">
            <label for="formGroupExampleInput" class="form-label">Product name</label>
            <input type="text" name="productName" class="form-control" id="formGroupExampleInput"
            >
        </div>
        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Price</label>
            <input type="text" name="price" class="form-control" id="formGroupExampleInput2">
        </div>

        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Quantity</label>
            <input type="text" name="quantity" class="form-control" id="formGroupExampleInput3"
            >
        </div>

        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Image</label>
            <input type="text" name="image" class="form-control" id="formGroupExampleInput4">
        </div>

        <div class="mb-3">
            <label for="formGroupExampleInput2" class="form-label">Type</label>
            <select id="mySelect" onchange="showInput()" name="type">
                <option readonly>Select your choice</option>
                <c:forEach items="${typeList}" var="type">
                    <option value="${type}">${type}</option>
                </c:forEach>
                <option value="other">Other</option>
            </select>
            <input name="otherType" type="text" id="otherInput" style="display: none"/>
        </div>
        <div class="btn__container d-flex justify-content-center mt-3">
            <button type="submit" class="btn btn-primary">Save change</button>
        </div>
    </div>
</form>

<jsp:include page="./temp-decoration/footer.jsp"></jsp:include>
</body>
<script src="./asset/js/bootstrap.bundle.js">
</script>
<script>
    function showInput() {
        let selectBox = document.getElementById("mySelect");
        let otherInput = document.getElementById("otherInput");

        if (selectBox.value === "other") {
            otherInput.style.display = "block";
        } else {
            otherInput.style.display = "none";
        }
    }
</script>
</html>
