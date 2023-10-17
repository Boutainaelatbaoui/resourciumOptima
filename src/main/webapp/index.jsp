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

    <link rel="stylesheet" href="assets/css/style.css">
</head>
<body class="d-flex flex-column min-vh-100">
<jsp:include page="views/header.jsp" />

<main class="py-5 my-3 container">
    <section class="bg-white dark:bg-gray-900">
        <div class="container py-8 px-4 mx-auto max-w-screen-xl">
            <div class="row gap-4 gap-md-0 align-items-center">
                <div class="col-md-4">
                    <img class="img-fluid d-none d-md-block" style="min-height: 50px !important; min-width: 50px !important;" src="assets/img/young people discussing team project at a laptop.png" alt="dashboard image">
                </div>
                <div class="col-md-8 mt-4 mt-md-0">
                    <h2 class="mb-4 text-4xl fw-extrabold text-gray-900 dark:text-white">Empower Your Team and Achieve Success</h2>
                    <p class="mb-6 text-gray-500 md:text-lg dark:text-gray-400">Unlock the potential for excellence in your team's collaboration. Suspendisse in turpis at nulla cursus vestibulum. Etiam non dui vel neque blandit feugiat. Empower your team to achieve greatness and foster efficient teamwork. Suspendisse in turpis at nulla cursus vestibulum. Etiam non dui vel neque blandit feugiat.</p>
                    <a href="${pageContext.request.contextPath}/views/login.jsp" class="btn btn-primary btn-lg rounded-pill">
                        Get started
                        <svg class="ms-2" width="20" height="20" fill="currentColor" class="bi bi-arrow-right" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
                        </svg>
                    </a>
                </div>
            </div>
        </div>
    </section>

    <section class="bg-white dark:bg-gray-900 mt-5">
        <div class="container py-8 px-4 d-flex gap-16 items-center">
            <div class="col-6 font-light text-gray-500 sm:text-lg dark:text-gray-400 mt-5 pt-5">
                <h2 class="mb-4 text-4xl tracking-tight font-extrabold text-gray-900 dark:text-white">Revolutionize Talent and Equipment Management</h2>
                <p class="mb-4">Introducing an advanced enterprise-level solution designed to streamline talent and equipment management processes within organizations. This powerful tool empowers HR managers and supervisors with an intuitive interface to efficiently coordinate and optimize tasks related to both employees and equipment.</p>
                <a href="#" class="btn btn-primary btn-lg rounded-pill">
                    About us
                    <svg class="ms-2" width="20" height="20" fill="currentColor" class="bi bi-arrow-right" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M10.293 3.293a1 1 0 011.414 0l6 6a1 1 0 010 1.414l-6 6a1 1 0 01-1.414-1.414L14.586 11H3a1 1 0 110-2h11.586l-4.293-4.293a1 1 0 010-1.414z" clip-rule="evenodd"></path>
                    </svg>
                </a>
            </div>
            <div class="col-6">
                <div class="row g-4">
                    <div class="col-md-6">
                        <img class="w-full img-fluid rounded-lg" src="https://flowbite.s3.amazonaws.com/blocks/marketing-ui/content/office-long-2.png" alt="office content 1">
                    </div>
                    <div class="col-md-6">
                        <img class="mt-4 w-full img-fluid mt-5 pt-5 rounded-lg" src="https://flowbite.s3.amazonaws.com/blocks/marketing-ui/content/office-long-1.png" alt="office content 2">
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>


<jsp:include page="views/footer.jsp" />
</body>
</html>