<%@ page import="java.util.List" %>
<%@ page import="com.example.companymanagement.entity.Employee" %>
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
        <div id="modal-task">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="${pageContext.request.contextPath}/task/create" method="POST" id="form-task">
                        <div class="modal-header">
                            <h5 class="modal-title fw-bold">Add New Task</h5>
                        </div>
                        <div class="modal-body">
                            <input type="hidden" name="action" value="create">
                            <div class="row mb-3">
                                <div class="col-md-6 col-sm-12">
                                    <label class="form-label">Description</label>
                                    <input type="text" class="form-control" name="description" id="task-description"/>
                                </div>
                                <div class="col-md-6 col-sm-12">
                                    <label class="form-label">Priority</label>
                                    <input type="number" class="form-control" name="priority" id="task-priority"/>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Status</label>
                                <select class="form-select" name="status" id="task-status">
                                    <option value="1">To Do</option>
                                    <option value="2">In Progress</option>
                                    <option value="3">Done</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Deadline</label>
                                <input type="date" class="form-control" name="deadline" id="task-deadline"/>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Responsibilities</label>
                                <textarea class="form-control" name="responsibilities" id="task-responsibilities"></textarea>
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Assigned Employee</label>
                                <select class="form-select" name="assignedEmployee" id="task-assigned-employee">
                                    <option value="">Please select</option>
                                        <% List<Employee> employees = (List<Employee>) request.getAttribute("employees");
                                            for (Employee employee : employees) { %>
                                        <option value="<%= employee.getId() %>"><%= employee.getFullName() %></option>
                                        <% } %>
                                </select>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="submit" name="save" class="btn btn-primary task-action-btn" id="task-save-btn">Save</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </div>
</main>
</body>
</html>
