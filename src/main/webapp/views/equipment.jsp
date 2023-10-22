<%@ page import="com.example.companymanagement.entity.Equipment" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.companymanagement.service.EquipmentCategoryService" %>
<%@ page import="com.example.companymanagement.entity.EquipmentCategory" %>
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
<main class="mt-3 mb-5">
  <div class="main-dash">
    <%
      String successMessage = (String) request.getSession().getAttribute("successMessage");
    %>
    <% if (successMessage != null) { %>
    <div class="alert alert-success alert-dismissible fade show mt-2" role="alert">
      <strong>Success!</strong> <%= successMessage %>
      <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    <% } %>
    <div class="card welcome-card text-center bx-shadow">
      <div class="card-style"></div>
      <div class="card-body box-card">
        <div class="card-title">
          <a class="navbar-brand mx-5 pe-5" href="${pageContext.request.contextPath}/index.jsp">
                <span class="logo">
                    <span class="" style="color: #266ef5 !important;">HR</span> Zone
                </span>
          </a>
        </div>
        <div class="card-text mb-4">
          <h4 class="mt-1 fw-bolder">Welcome back <i class="bi bi-quote"></i><%= session.getAttribute("username") %><i class="bi bi-quote"></i> <span>&#128075;</span></h4>
        </div>
        <a href="${pageContext.request.contextPath}/create-equi" class="btn btn-modal">Add New Equipment</a>
      </div>
    </div>
    <h1 class="fw-bold text-center mt-4">Equipments</h1>
    <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 row-cols-lg-3 mt-5">
      <%
        List<Equipment> equipments = (List<Equipment>) request.getAttribute("equipments");

        if (equipments != null && !equipments.isEmpty()) {
          for (Equipment equipment : equipments) {
            EquipmentCategory equipmentCategory = equipment.getEquipmentCategory();
      %>
      <div class="col">
        <div class="card card-menu btn bg-white mb-3 p-0" style="background-color: white !important;">
          <div class="card-body">
            <div class="d-flex justify-content-center gap-2 align-items-center">
              <% if (equipmentCategory.getCategory_id() == 1) { %>
              <img class="mb-3" src="${pageContext.request.contextPath}/assets/img/Workstation.png" width="80" height="80" alt="image">
              <% } else if (equipmentCategory.getCategory_id() == 2) { %>
              <img class="mb-3" src="${pageContext.request.contextPath}/assets/img/Sliding%20Door%20Closet.png" width="80" height="80" alt="image">
              <% } else if (equipmentCategory.getCategory_id() == 3) { %>
              <img class="mb-3" src="${pageContext.request.contextPath}/assets/img/Cab%20Stand.png" width="80" height="80" alt="image">
              <% } else if (equipmentCategory.getCategory_id() == 4) { %>
              <img class="mb-3" src="${pageContext.request.contextPath}/assets/img/Gear.png" width="80" height="80" alt="image">
              <% } else { %>
              <img class="mb-3" src="${pageContext.request.contextPath}/assets/img/Tools.png" width="80" height="80" alt="image">
              <% } %>
              <div>
                <h5 class="mb-1 text-xl font-medium text-center"><%= equipment.getName() %></h5>
                <span class="text-sm fs-6 text-muted text-center"><%= (equipmentCategory != null) ? equipmentCategory.getName() : "N/A" %></span>
              </div>
            </div>
            <div class="d-flex justify-content-center gap-4 mb-2 mt-3">
              <h6 class="text-xl font-medium"><span class="fw-bolder fs-6 me-1">Quantity:</span><%= equipment.getQuantity() %></h6>
              <h6 class="text-xl font-medium"><span class="fw-bolder fs-6 me-1">cost:</span><%= equipment.getCost() %></h6>
            </div>
            <span class="fw-bolder fs-6 me-1 mb-2">Date of maintenance:</span><h6 class="mb-1 text-xl font-medium"><%= equipment.getDate_of_maintenance() %></h6>
            <span class="fw-bolder fs-6 me-1 mb-2">Date of purchase:</span><h6 class="mb-1 text-xl font-medium"><%= equipment.getDate_of_purchase() %></h6>
            <div class="mt-4">
              <a href="#" class="btn btn-sm btn-primary me-3 px-4 text-sm"><i class="bi bi-pencil-square users-icon text-white me-2"></i>Update</a>
              <a href="#" class="btn btn-sm btn-danger px-4 text-sm"><i class="bi bi-trash3 users-icon text-white me-2"></i>Delete</a>
            </div>
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
            <p>No Equipments to display.</p>
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
