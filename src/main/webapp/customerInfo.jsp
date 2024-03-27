<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang Web của Tôi</title>
    <link rel="stylesheet" href="./asset/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <header class="header">
        <img src="https://salt.tikicdn.com/ts/upload/0e/07/78/ee828743c9afa9792cf20d75995e134e.png" alt="Logo">
    </header>
    <br>
    <div class="column" id="containerLeft">
        <ul class="nav flex-column">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page">Account Information</a>
            </li>
            <li class="nav-item">
                <a class="nav-link">Notification</a>
            </li>
            <li class="nav-item">
                <a class="nav-link">My Purchase</a>
            </li>
            <li class="nav-item">
                <a class="nav-link">Banks & Cards</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled">Disabled</a>
            </li>
        </ul>
    </div>
    <div class="column" id="containerCenter">
        <div id="info">My Account</div>
        <form>
            <div>My Profile</div>
            <div class="form-control">
                <label class="input-label">Full name</label>
                <input name="name" type="text" placeholder="Trương Trác Văn">
            </div>
            <div class="form-control">
                <label class="input-label">Date of Birth</label>
                <select name="date" class="form-select" aria-label="Default select example">
                    <option selected>Day</option>
                    <option value="1"> 1</option>
                    <option value="2"> 2</option>
                    <option value="3"> 3</option>
                    <option value="4"> 4</option>
                    <option value="5"> 5</option>
                    <option value="6"> 6</option>
                    <option value="7"> 7</option>
                    <option value="8"> 8</option>
                    <option value="9"> 9</option>
                    <option value="10"> 10</option>
                    <option value="11"> 11</option>
                    <option value="12"> 12</option>
                    <option value="13"> 13</option>
                    <option value="14"> 14</option>
                    <option value="15"> 15</option>
                    <option value="16"> 16</option>
                    <option value="17"> 17</option>
                    <option value="18"> 18</option>
                    <option value="19"> 19</option>
                    <option value="20"> 20</option>
                    <option value="21"> 21</option>
                    <option value="22"> 22</option>
                    <option value="23"> 23</option>
                    <option value="24"> 24</option>
                    <option value="25"> 25</option>
                    <option value="26"> 26</option>
                    <option value="27"> 27</option>
                    <option value="28"> 28</option>
                    <option value="29"> 29</option>
                    <option value="30"> 30</option>
                    <option value="31"> 31</option>
                </select>
                <select name="month" class="form-select" aria-label="Default select example">
                    <option selected>Month</option>
                    <option value="1">Jan</option>
                    <option value="2">Feb</option>
                    <option value="3">Marc</option>
                    <option value="4">Apr</option>
                    <option value="5">May</option>
                    <option value="6">Jun</option>
                    <option value="7">Jul</option>
                    <option value="8">Aug</option>
                    <option value="9">Sep</option>
                    <option value="10">Oct</option>
                    <option value="11">Nov</option>
                    <option value="12">Dec</option>
                </select>
                <select name="year" class="form-select" aria-label="Default select example">
                    <%
                        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                        int startYear = currentYear - 100;
                        int endYear = currentYear;
                    %>
                    <option value=0>Year</option>

                    <%
                        for (int year = endYear; year >= startYear; year--) {
                    %>
                    <option value="<%= year %>"><%= year %>
                    </option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div class="form-control">
                <label class="input-label">Gender</label>

                <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="male">
                <label class="form-check-label" for="inlineCheckbox1">Male</label>

                <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="female">
                <label class="form-check-label" for="inlineCheckbox2">Female</label>

                <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="other">
                <label class="form-check-label" for="inlineCheckbox3">Other</label>
            </div>
            <div class="form-control">
                <label class="input-label">Nationality</label>
                <select class="form-select" aria-label="Default select example">
                    <option value="">Your nationality</option>
                    <option value="vn">Việt Nam</option>
                    <option value="us">US</option>
                    <option value="uk">UK</option>
                    <option value="fr">France</option>
                </select>
            </div>
            <div class="form-control">
                <label class="input-label">Wallet</label>
                <input type="text" value="wallet">
            </div>
            <button class="submit" type="submit">Save changed</button>
        </form>
    </div>
    <div class="column" id="containerRight">
        <span>Phone number & Email</span>
        <div class="list-item">
            <div class="info">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-telephone" viewBox="0 0 16 16">
                    <path d="M3.654 1.328a.678.678 0 0 0-1.015-.063L1.605 2.3c-.483.484-.661 1.169-.45 1.77a17.6 17.6 0 0 0 4.168 6.608 17.6 17.6 0 0 0 6.608 4.168c.601.211 1.286.033 1.77-.45l1.034-1.034a.678.678 0 0 0-.063-1.015l-2.307-1.794a.68.68 0 0 0-.58-.122l-2.19.547a1.75 1.75 0 0 1-1.657-.459L5.482 8.062a1.75 1.75 0 0 1-.46-1.657l.548-2.19a.68.68 0 0 0-.122-.58zM1.884.511a1.745 1.745 0 0 1 2.612.163L6.29 2.98c.329.423.445.974.315 1.494l-.547 2.19a.68.68 0 0 0 .178.643l2.457 2.457a.68.68 0 0 0 .644.178l2.189-.547a1.75 1.75 0 0 1 1.494.315l2.306 1.794c.829.645.905 1.87.163 2.611l-1.034 1.034c-.74.74-1.846 1.065-2.877.702a18.6 18.6 0 0 1-7.01-4.42 18.6 18.6 0 0 1-4.42-7.009c-.362-1.03-.037-2.137.703-2.877z"/>
                </svg>
                <span>Phone number</span>
                <span>xx-xxxx-xxx</span>
            </div>
            <div class="info">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                     class="bi bi-envelope" viewBox="0 0 16 16">
                    <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z"/>
                </svg>
                <span>Email</span>
                <span>xxxxx@gmail.com</span>
            </div>
            <p>Secure</p>
            <div class="info">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-lock"
                     viewBox="0 0 16 16">
                    <path d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2m3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2M5 8h6a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1H5a1 1 0 0 1-1-1V9a1 1 0 0 1 1-1"/>
                </svg>
                <span>Change Password</span>
            </div>
        </div>

    </div>


</div>


<footer class="footer">

</footer>
</body>
</html>