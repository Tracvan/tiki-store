<%--
  Created by IntelliJ IDEA.
  User: Bap
  Date: 3/26/2024
  Time: 1:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Landing Page</title>
    <link rel="stylesheet" href="./asset/css/bootstrap.css">
    <link rel="stylesheet" href="./asset/css/landingStyle.css">
    <link rel="stylesheet" href="./asset/css/authStyle.css">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/accountInformation">Account Information</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="search__input form-control me-2" type="search" placeholder="Search"
                       aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<main>
    <div class="container-main-heading container">Products</div>

    <div class="main-container container-xxl">
        <div class="row ">
            <div class="catagory col d-flex flex-column">
                <div class="catagory-item">
                    <a href="" class="catagory-item-name">
                        Test
                    </a>
                </div>

                <div class="catagory-item">
                    <a href="" class="catagory-item-name">
                        Test
                    </a>
                </div>

                <div class="catagory-item">
                    <a href="" class="catagory-item-name">
                        Test
                    </a>
                </div>

                <div class="catagory-item">
                    <a href="" class="catagory-item-name">
                        Test
                    </a>
                </div>

                <div class="catagory-item">
                    <a href="" class="catagory-item-name">
                        Test
                    </a>
                </div>
            </div>

            <div class="display-product col-10">
                <div class="row">
                    <div class="card col-5">
                        <img src="https://m.media-amazon.com/images/I/71yGtauB-AL._AC_SL1500_.jpg"
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up
                                the
                                bulk of
                                the card's
                                content.</p>
                            <p>So luong</p>
                            <a href="#" class="btn btn-primary">Add to cart</a>
                            <a href="#" class="btn btn-primary">Buy</a>
                        </div>
                    </div>

                    <div class="card col-5">
                        <img src="https://m.media-amazon.com/images/I/71yGtauB-AL._AC_SL1500_.jpg"
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up
                                the
                                bulk of
                                the card's
                                content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>

                    <div class="card col-5">
                        <img src="https://product.hstatic.net/200000601791/product/5_5d17c7eec19b492193fecec066985240_master.jpg"
                             class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up
                                the
                                bulk of
                                the card's
                                content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>

                    <div class="card col-5">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up
                                the
                                bulk of
                                the card's
                                content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>

                    <div class="card col-5">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up
                                the
                                bulk of
                                the card's
                                content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>

                    <div class="card col-5">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up
                                the
                                bulk of
                                the card's
                                content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>

                    <div class="card col-5">
                        <img src="..." class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up
                                the
                                bulk of
                                the card's
                                content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>


<footer>
    <div class="feature-support">
        <div class="container-list">
            <div class="container-list-1">
                <ul>
                    <li class="heading">Customer service</li>
                    <li><a href="">Hellp Center</a></li>
                    <li><a href="">Blog</a></li>
                    <li><a href="">Mail</a></li>
                    <li><a href="">Shopping guide</a></li>
                    <li><a href="">Sales guide</a></li>
                    <li><a href="">Pay</a></li>
                    <li><a href="">Coin</a></li>
                    <li><a href="">Transport</a></li>
                    <li><a href="">Customer Care</a></li>
                    <li><a href="">Warranty Policy</a></li>
                </ul>
            </div>

            <div class="container-list-2">
                <ul>
                    <li class="heading">About us</li>
                    <li><a href="">Introducing Shopee Vietnam</a></li>
                    <li><a href="">Recruitment</a></li>
                    <li><a href="">Shopee Terms</a></li>
                    <li><a href="">Privacy Policy</a></li>
                    <li><a href="">Genuine</a></li>
                    <li><a href="">Seller Channel</a></li>
                    <li><a href="">Flash Sales</a></li>
                    <li><a href="">Affiliate Marketing Program</a></li>
                    <li><a href="">Media Contact</a></li>
                </ul>
            </div>

            <div class="container-list-3">
                <div class="pay">
                    <ul>
                        <li class="heading">Pay</li>
                    </ul>
                    <div class="payment-image d-flex flex-wrap">
                        <img src="https://down-vn.img.susercontent.com/file/d4bbea4570b93bfd5fc652ca82a262a8"
                             alt="Visa">
                        <img src="https://down-vn.img.susercontent.com/file/a0a9062ebe19b45c1ae0506f16af5c16"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/38fd98e55806c3b2e4535c4e4a6c4c08"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/bc2a874caeee705449c164be385b796c"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/2c46b83d84111ddc32cfd3b5995d9281"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/5e3f0bee86058637ff23cfdf2e14ca09"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/9263fa8c83628f5deff55e2a90758b06"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/0217f1d345587aa0a300e69e2195c492"
                             alt="">
                    </div>
                </div>
                <div class="transport">
                    <ul>
                        <li class="heading">TRANSPORT UNIT</li>
                    </ul>
                    <div class="payment-image d-flex flex-wrap">
                        <img src="https://down-vn.img.susercontent.com/file/vn-50009109-159200e3e365de418aae52b840f24185"
                             alt="Visa">
                        <img src="https://down-vn.img.susercontent.com/file/d10b0ec09f0322f9201a4f3daf378ed2"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/vn-50009109-64f0b242486a67a3d29fd4bcf024a8c6"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/59270fb2f3fbb7cbc92fca3877edde3f"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/957f4eec32b963115f952835c779cd2c"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/0d349e22ca8d4337d11c9b134cf9fe63"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/3900aefbf52b1c180ba66e5ec91190e5"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/6e3be504f08f88a15a28a9a447d94d3d"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/b8348201b4611fc3315b82765d35fc63"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/0b3014da32de48c03340a4e4154328f6"
                             alt="">
                        <img src="https://down-vn.img.susercontent.com/file/vn-50009109-ec3ae587db6309b791b78eb8af6793fd"
                             alt="">
                    </div>
                </div>
            </div>

            <div class="container-list-4">
                <ul>
                    <li class="heading">Follow us on</li>
                    <li><a href="">Facebook</a></li>
                    <li><a href="">Instagram</a></li>
                    <li><a href="">LinkedIn</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="infor-container">
        <hr>
        <p>
            Địa chỉ: Tầng 4-5-6, Tòa nhà Capital Place, số 29 đường Liễu Giai, Phường Ngọc Khánh, Quận Ba Đình,
            Thành
            phố
            Hà Nội,
            Việt Nam. Tổng đài hỗ trợ: 19001221 - Email: cskh@hotro.shopee.vn
        </p>
        <p>
            Chịu Trách Nhiệm Quản Lý Nội Dung: Nguyễn Đức Trí - Điện thoại liên hệ: 024 73081221 (ext 4678)
        </p>
        <p>
            Mã số doanh nghiệp: 0106773786 do Sở Kế hoạch & Đầu tư TP Hà Nội cấp lần đầu ngày 10/02/2015
        </p>
        <p>
            © 2015 - Bản quyền thuộc về Công ty TNHH Shopee
        </p>
    </div>
</footer>
</body>
</html>
