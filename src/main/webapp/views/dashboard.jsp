<%@ page import="com.example.companymanagement.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.companymanagement.entity.JobTitle" %>
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

    <link rel="stylesheet" href="./assets/css/style.css">

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
<main class="mt-3 mb-5">
    <div class="main-dash">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-3 mt-5">
            <%
                List<Employee> employees = (List<Employee>) request.getAttribute("employees");

                if (employees != null && !employees.isEmpty()) {
                    for (Employee employee : employees) {
                        JobTitle jobTitle = employee.getJobTitle();
            %>
            <div class="col">
                <div class="card card-menu btn bg-white mb-3 p-0">
                    <div class="card-body text-center">
                        <img class="mb-3 rounded-circle shadow-lg" src="./assets/img/A%20female%20office.png" width="100" height="100" alt="image">
                        <h5 class="mb-1 text-xl font-medium"><%= employee.getFullName() %></h5>
                        <span class="text-sm text-muted"><%= (jobTitle != null) ? jobTitle.getTitle_name() : "N/A" %></span>
                        <% if ("Manager".equals(jobTitle)) {%>
                            <div class="mt-4">
                                <a href="#" class="btn btn-sm btn-primary me-3 px-4 text-sm"><i class="bi bi-pencil-square users-icon text-white me-2"></i>Update</a>
                                <a href="#" class="btn btn-sm btn-danger px-4 text-sm"><i class="bi bi-trash3 users-icon text-white me-2"></i>Delete</a>
                            </div>
                        <%}%>
                    </div>
                </div>
            </div>
            <%
                }
            } else {
            %>
            <div class="col">
                <div class="card bg-light">
                    <div class="card-body text-center">
                        <p>No employees to display.</p>
                    </div>
                </div>
            </div>
            <%
                }
            %>
        </div>
    </div>
</main>



</body>
</html>