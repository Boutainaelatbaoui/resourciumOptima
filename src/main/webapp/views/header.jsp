<nav class="navbar navbar-expand-lg navbar-white bg-white d-flex navbar-welcome py-2">
  <div class="container">
    <a class="navbar-brand mx-5 pe-5" href="${pageContext.request.contextPath}/index.jsp">
                <span class="logo">
                    <span class="" style="color: #266ef5 !important;">HR</span> Zone
                </span>
    </a>
    <button class="navbar-toggler mx-4" type="button" data-bs-toggle="collapse" data-bs-target="#menuItems" aria-controls="menuItems" aria-expanded="false" aria-label="Toggle Navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="menuItems">
      <!-- Left Side Of Navbar -->
      <ul class="navbar-nav ps-5 mt-2 mt-lg-0 ms-5 ms-lg-0 text-decoration-none fs-6">
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
      <% if (session.getAttribute("username") == null) { %>
        <ul class="navbar-nav ms-auto me-4">
          <!-- Authentication Links -->
          <li class="nav-item">
            <a class="nav-link nav-user px-3 btn btn-one me-3 mt-2 mt-lg-0 ms-4 ms-lg-0" href="${pageContext.request.contextPath}/views/login.jsp">Login</a>
          </li>

          <li class="nav-item">
            <a class="nav-link nav-user px-3 btn btn-one mt-3 mt-lg-0 ms-4 ms-lg-0" href="<%= request.getContextPath() %>/jobTitle">Register</a>
          </li>
        </ul>
      <% } %>

      <% if (session.getAttribute("username") != null) { %>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav d-flex ms-auto">
          <li class="nav-item dropdown">
              <a id="navbarDropdown" class="nav-link nav-dash dropdown-toggle nav-user btn btn-two me-3" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <img class="rounded-circle me-1" src="assets/img/A%20female%20office.png" alt="user photo" width="45" height="45">
                <%= session.getAttribute("username") %>
              </a>
            <div class="dropdown-menu dropdown-menu-center ms-4 ms-lg-0">
                <span class="block text-sm text-gray-900 ms-4"><%= session.getAttribute("jobTitle") %></span>
              <hr>
              <a class="dropdown-item" href="<%= request.getContextPath() %>/views/dashboard.jsp">Dashboard</a>
              <a class="dropdown-item" href="<%= request.getContextPath() %>/editProfile">
                Edit Profile
              </a>
              <a class="dropdown-item" href="<%= request.getContextPath() %>/changePassword">Change Password</a>
              <form action="<%= request.getContextPath() %>/logout" method="get">
                <input type="hidden" name="logout" value="true">
                <button type="submit" class="dropdown-item">Logout</button>
              </form>
            </div>
          </li>
        </ul>
      </div>
      <% } %>
    </div>
  </div>
</nav>