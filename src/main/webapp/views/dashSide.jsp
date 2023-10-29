<div class="offcanvas offcanvas-start sidebar-nav" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
    <div class="offcanvas-header">

        <button type="button" class="btn-close close-offcanvas" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body p-0">
        <nav class="navbar-dark px-4">
            <ul class="navbar-nav sidebar-text mt-4">
                <li>
                    <a href="${pageContext.request.contextPath}/index.jsp" class="nav-link mt-2 me-5">
                        <span class="me-4"><i class="bi bi-house-fill"></i></span>
                        <span>Home</span>
                    </a>
                </li>
                <li>
                    <a href="<%= request.getContextPath() %>/dashboard" class="nav-link active mt-2">
                        <span class="me-4"><i class="bi bi-grid-1x2-fill"></i></span>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/equipment/list?action=equipmentAction" class="nav-link active mt-2">
                        <span class="me-4"><i class="bi bi-tools"></i></span>
                        <span>Equipments</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/reservation?action=view" class="nav-link active mt-2">
                        <span class="me-4"><i class="bi bi-calendar-check"></i></span>
                        <span>Reservations</span>
                    </a>
                </li>
                <li>
                    <a href="<%= request.getContextPath() %>/dashboard" class="nav-link active mt-2">
                        <span class="me-4"><i class="bi bi-grid-1x2-fill"></i></span>
                        <span>Job Titles</span>
                    </a>
                </li>
                <li>
                    <a href="<%= request.getContextPath() %>/dashboard" class="nav-link active mt-2">
                        <span class="me-4"><i class="bi bi-pin-fill"></i></span>
                        <span>Categories</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/task/list" class="nav-link active mt-2">
                        <span class="me-4"><i class="bi bi-calendar-check"></i></span>
                        <span>Tasks</span>
                    </a>
                </li>
                <li class="position-absolute bottom-0 mb-5 ms-2 fw-bolder fs-6">
                    <form action="<%= request.getContextPath() %>/logout" method="get">
                        <input type="hidden" name="logout" value="true">
                        <button type="submit" class="dropdown-item">Logout</button>
                    </form>
                </li>
            </ul>
        </nav>
    </div>
</div>