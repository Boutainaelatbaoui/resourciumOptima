<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>
        RH Zone
    </title>

    <!-- Styles -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

    <link rel="stylesheet" href="./assets/css/style.css">
</head>
<body class="d-flex flex-column min-vh-100">
<div class="" id="app">
    <nav class="navbar navbar-expand-lg navbar-white bg-white d-flex navbar-welcome py-2">
        <div class="container">
            <a class="navbar-brand mx-5 pe-5" href="">
                <span class="logo">
                    <span class="" style="color: #266ef5 !important;">HR</span> Zone
                </span>
            </a>
            <button class="navbar-toggler mx-4" type="button" data-bs-toggle="collapse" data-bs-target="#menuItems" aria-controls="menuItems" aria-expanded="false" aria-label="Toggle Navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="menuItems">
                <!-- Left Side Of Navbar -->
                <ul class="navbar-nav ps-5 mt-2 mt-lg-0 ms-5 ms-lg-0 text-decoration-none fs-5">
                    <li class="nav-item">
                        <a class="nav-link nav-app text-dark me-2" href="">About us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-app text-dark me-2" href="">Our team</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link nav-app text-dark me-2" href="">Features</a>
                    </li>
                </ul>

                <!-- Right Side Of Navbar -->
                <ul class="navbar-nav ms-auto me-4">
                    <!-- Authentication Links -->
                    <li class="nav-item">
                        <a class="nav-link nav-user px-3 btn btn-one me-3 mt-2 mt-lg-0 ms-4 ms-lg-0" href="">Login</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link nav-user px-3 btn btn-one mt-3 mt-lg-0 ms-4 ms-lg-0" href="">Register</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <main class="py-4">
    </main>
</div>
<footer class="text-center text-lg-start footer-one mt-auto">
    <div class="container d-flex justify-content-center py-5">
        <button type="button" class="btn btn-footer btn-lg btn-floating mx-2">
            <i class="bi bi-facebook text-center"></i>
        </button>
        <button type="button" class="btn btn-footer btn-lg btn-floating mx-2">
            <i class="bi bi-instagram text-center"></i>
        </button>
        <button type="button" class="btn btn-footer btn-lg btn-floating mx-2">
            <i class="bi bi-twitter text-center"></i>
        </button>
        <button type="button" class="btn btn-footer btn-lg btn-floating mx-2">
            <i class="bi bi-youtube text-center"></i>
        </button>
    </div>
    <!-- Copyright -->
    <div class="text-center p-3 footer-two">
        © 2023 Copyright:
        <a class="text-decoration-none fw-bolder text-dark" href="https://youcode.ma/">YouCode</a>
    </div>
    <!-- Copyright -->
</footer>
</body>
</html>