<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title></head>
<body>
<div class="container">
    <header class="header">
        <img src="https://salt.tikicdn.com/ts/upload/0e/07/78/ee828743c9afa9792cf20d75995e134e.png" alt="Logo">
    </header>
    <br>
    <h1>Add New Product</h1>
    <div class="container">
        <form method="post">
            <div class="input-group">
                <span class="input-group-text">Product's name</span>
                <input type="text" value="productName" class="form-control" aria-label="Prodcut's name"></input>
            </div>

            <div class="input-group">
                <span class="input-group-text">Product's price</span>
                <input type="text" value="productPrice" class="form-control" aria-label="Prodcut's price"></input>
            </div>

            <div class="input-group">
                <span class="input-group-text">Product's quantity</span>
                <input type="text" value="productQuantity" class="form-control" aria-label="Prodcut's quantity"></input>
            </div>

            <div class="input-group">
                <span class="input-group-text">Product's type</span>
                <input type="text" value="productType" class="form-control" aria-label="Prodcut's type"></input>
            </div>

            <div class="input-group">
                <span class="input-group-text">Product's imagae</span>
                <input type="text" value="productImage" class="form-control" aria-label="Prodcut's image"></input>
            </div>
            <button class="submit" type="submit">Save</button>
        </form>
    </div>
</div>
</body>
</html>
