<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.example.companymanagement.entity.*" %>
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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">

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
<%
    List<EquipmentReservation> allReservations = (List<EquipmentReservation>) request.getAttribute("allReservations");
    Employee loggedInEmployee = (Employee) session.getAttribute("employee");
    boolean isManager = loggedInEmployee.getJobTitle().getTitle_name().equals("Manager");
%>
<%!
    public String formatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return (date != null) ? sdf.format(date) : "";
    }
%>
<main class="mt-3 mb-5">
    <div class="main-dash">
        <div class="d-flex items-center">
            <h2 class="me-4"><i class="bi bi-calendar-check"></i></h2>
            <h2>Reservations</h2>
        </div>
        <table id="data-table" class="display dataTable mb-3 mt-3" style="width: 100%" aria-describedby="example_info">
            <thead>
            <tr>
                <th>Name</th>
                <th>Reservation Date</th>
                <th>Return Date</th>
                <th>Status</th>
                <th>Employee</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (EquipmentReservation reservation : allReservations) {
                    Employee reservationEmployee = reservation.getEmployee();
                    boolean showReservation = isManager || (reservationEmployee.getId() == loggedInEmployee.getId());
                    if (showReservation) {
            %>
            <tr>
                <td><%= reservation.getEquipment().getName() %></td>
                <td><%= reservation.getReservation_date() %></td>
                <td><%= reservation.getReservation_return() %></td>
                <td><%= reservation.getStatusEquipment() %></td>
                <td><%= reservation.getEmployee().getFullName() %></td>
                <td>
                    <div class="d-flex fs-3">
                        <form action="" method="post">
                            <a href="" class="btn btn-warning me-3"><i class="bi bi-pencil-square users-icon text-white"></i></a>
                            <button type="submit" class="btn btn-danger text-dark"><i class="bi bi-trash3 users-icon text-white"></i></button>
                        </form>
                    </div>
                </td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
    </div>
</main>
<!-- ================== BEGIN core-js ================== -->
<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.21/js/jquery.dataTables.min.js" integrity="sha512-BkpSL20WETFylMrcirBahHfSnY++H2O1W+UnEEO4yNIl+jI2+zowyoGJpbtk6bx97fBXf++WJHSSK2MV4ghPcg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
    $(document).ready(function() {
        $("#data-table").DataTable({
            scrollX: true,
            info: false,
            responsive: true,
        });
    });
</script>
<!-- ================== END core-js ================== -->
</body>
</html>
