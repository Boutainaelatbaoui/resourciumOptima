<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>
        RH Zone
    </title>

    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />
    <!-- ================== BEGIN core-css ================== -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="//cdn.datatables.net/1.13.1/css/jquery.dataTables.min.css" />

    <link rel="stylesheet" href="../assets/css/style.css">

    <!-- ================== END core-css ================== -->
    <!-- BEGIN parsley css-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/guillaumepotier/Parsley.js@2.9.2/doc/assets/docs.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/guillaumepotier/Parsley.js@2.9.2/src/parsley.css">
    <!-- END parsley css-->
    <!-- BEGIN jquery js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <!-- END jquery js-->
    <!-- BEGIN parsley js -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/parsley.js/2.9.2/parsley.min.js" integrity="sha512-eyHL1atYNycXNXZMDndxrDhNAegH2BDWt1TmkXJPoGf1WLlNYt08CSjkqF5lnCRmdm3IrkHid8s2jOUY4NIZVQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <!-- END parsley js-->
</head>
<body class="d-flex flex-column min-vh-100">
<jsp:include page="dashHeader.jsp" />
<jsp:include page="dashSide.jsp" />
<main class="py-5 my-3 container">
    <div class="">
        <div class="card-header">
            <button id="dropdownButton" class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown">
                <span class="sr-only">Open dropdown</span>
                <svg class="bi bi-three-dots" width="16" height="3" fill="currentColor" viewBox="0 0 16 3">
                    <path d="M2 0a1.5 1.5 0 1 1 0 3 1.5 1.5 0 0 1 0-3Zm6.041 0a1.5 1.5 0 1 1 0 3 1.5 1.5 0 0 1 0-3ZM14 0a1.5 1.5 0 1 1 0 3 1.5 1.5 0 0 1 0-3Z"/>
                </svg>
            </button>
            <!-- Dropdown menu -->
            <div class="dropdown-menu" id="dropdown">
                <a class="dropdown-item" href="#">Edit</a>
                <a class="dropdown-item" href="#">Export Data</a>
                <a class="dropdown-item text-danger" href="#">Delete</a>
            </div>
        </div>
        <div class="card-body text-center">
            <img class="w-24 h-24 mb-3 rounded-circle shadow-lg" src="../assets/img/A%20female%20office.png" alt="image">
            <h5 class="mb-1 text-xl font-medium">Bonnie Green</h5>
            <span class="text-sm text-muted">Visual Designer</span>
            <div class="mt-4">
                <a href="#" class="btn btn-primary btn-lg">Add friend</a>
                <a href="#" class="btn btn-secondary btn-lg">Message</a>
            </div>
        </div>
    </div>
</main>

</body>
</html>