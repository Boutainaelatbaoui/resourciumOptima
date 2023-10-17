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

    <link rel="stylesheet" href="../assets/css/style.css">
</head>
<body class="d-flex flex-column min-vh-100">
<jsp:include page="header.jsp" />

<main class="py-4">
    <div class="container container container-log h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col">
                <div class="card-form mb-3 m-auto">
                    <div class="row">
                        <div class="col d-none d-lg-block">
                            <img src="../assets/img/rh1.jpg" class="img-fluid img-form" id="img" alt="RH" min-height="200px">
                        </div>
                        <div class="col second-card">
                            <div class="mx-5">
                                <div class="d-flex justify-content-center align-items-center mt-3 mb-4">
                            <span class="logo">
                                <span class="" style="color: #266ef5 !important;">HR</span> Zone
                            </span>
                                </div>
                                <div class="text-center mb-3">
                                    <div>
                                        <h4 class="login-text">Hey, Hello <span>&#128075;</span></h4>
                                    </div>
                                    <div>
                                        <h5 class="login-detail">Create an account</h5>
                                    </div>
                                </div>
                                <form method="POST" action="" class="register-form">
                                    <div class="mb-3">
                                        <label for="name" class="form-label">Full name</label>
                                        <div class="">
                                            <input id="name" type="text" class="form-control" name="name" autocomplete="name" autofocus>
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <label for="email" class="form-label">Email address</label>
                                        <div class="">
                                            <input id="email" type="email" class="form-control" name="email" autocomplete="email">
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <label for="password" class="form-label">Password</label>
                                        <div class="">
                                            <input id="password" type="password" class="form-control" name="password" autocomplete="new-password">
                                        </div>
                                    </div>
                                    <div class="mb-4">
                                        <label for="password-confirm" class="form-label">Repeat your password</label>
                                        <div class="">
                                            <input id="password-confirm" type="password" class="form-control" name="password_confirmation" autocomplete="new-password">
                                        </div>
                                    </div>
                                    <div class="d-grid d-block mb-4 text-center">
                                        <button type="submit" name="signup" class="btn main-btn text-white" id="signup">Create account</button>
                                    </div>
                                </form>
                                <div class="login-mb">
                                    <p class="text-center text-form">Already have an account? <button class="btn btn main-btn btn-sm">
                                        <a href="login.jsp" class="text-decoration-none text-white text-center">Login</a></button></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<jsp:include page="footer.jsp" />
</body>
</html>
