<nav class="navbar navbar-dash navbar-expand-lg bg-dark text-white fixed-top">
  <div class="container-fluid">
    <!-- offcanvas trigger -->
    <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
      <span class="navbar-toggler-icon" data-bs-target="#offcanvasExample"></span>
    </button>
    <!-- offcanvas trigger -->
    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">
                <span class="logo">
                    <span class="" style="color: #266ef5 !important;">HR</span> <span class="text-white">Zone</span>
                </span>
    </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav d-flex ms-auto">
        <li class="nav-item dropdown">
          <a id="navbarDropdown" class="nav-link nav-dash dropdown-toggle nav-user btn btn-two me-3" style="color: #edf2f4 !important;" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <img class="rounded-circle me-1" src="${pageContext.request.contextPath}/assets/img/A%20female%20office.png" alt="user photo" width="45" height="45">
            <%= session.getAttribute("username") %>
          </a>
          <div class="dropdown-menu dropdown-menu-center ms-4 ms-lg-0">
            <span class="block text-sm text-gray-900 ms-4"><%= session.getAttribute("username") %></span>
            <hr>
            <a class="dropdown-item" href="<%= request.getContextPath() %>/editProfile">
              Edit Profile
            </a>
            <a class="dropdown-item" href="<%= request.getContextPath() %>/changePassword">Change Password</a>
            <a class="dropdown-item" href="<%= request.getContextPath() %>/logout">Logout</a>
          </div>
        </li>
      </ul>
    </div>
  </div>
</nav>