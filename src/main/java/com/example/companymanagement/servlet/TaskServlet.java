package com.example.companymanagement.servlet;

import com.example.companymanagement.entity.*;
import com.example.companymanagement.service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "TaskServlet", value = {"/task/view","/task/list", "/task/create", "/task/update", "/task/delete"})
public class TaskServlet extends HttpServlet {
    private TaskService taskService;
    private EmployeeService employeeService;

    public void init() {
        taskService = new TaskService();
        employeeService = new EmployeeService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {

            int taskId = Integer.parseInt(request.getParameter("id"));
            taskService.deleteTask(taskId);
            List<Task> allTasks = taskService.getAllTask();
            request.setAttribute("allTasks", allTasks);
            request.getRequestDispatcher("/views/task.jsp").forward(request, response);

        } else if ("view".equals(action)) {

            List<Employee> employees = employeeService.getAllEmployees();
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("/views/createTask.jsp").forward(request, response);

        } else if ("test".equals(action)) {
            String taskIdParam = request.getParameter("id");
            if (taskIdParam != null) {
                int taskId = Integer.parseInt(taskIdParam);
                Task task = taskService.getTaskById(taskId);

                if (task != null) {
                    List<Employee> employees = employeeService.getAllEmployees();
                    request.setAttribute("employees", employees);
                    request.setAttribute("task", task);
                    request.getRequestDispatcher("/views/editTask.jsp").forward(request, response);
                }
            }
        } else {

            List<Task> allTasks = taskService.getAllTask();
            request.setAttribute("allTasks", allTasks);
            request.getRequestDispatcher("/views/task.jsp").forward(request, response);

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String description = request.getParameter("description");
            int priority = Integer.parseInt(request.getParameter("priority"));
            int status = Integer.parseInt(request.getParameter("status"));

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date deadline = null;
            try {
                deadline = dateFormat.parse(request.getParameter("deadline"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String responsibilities = request.getParameter("responsibilities");
            int assignedEmployeeId = Integer.parseInt(request.getParameter("assignedEmployee"));

            Task newTask = new Task();
            newTask.setDescription(description);
            newTask.setPriority(priority);
            newTask.setStatus(status);
            newTask.setDeadline(deadline);
            newTask.setResponsibilities(responsibilities);

            EmployeeService employeeService = new EmployeeService();
            Employee assignedEmployee = employeeService.getEmployeeById(assignedEmployeeId);
            newTask.setAssignedEmployee(assignedEmployee);

            TaskService taskService = new TaskService();
            taskService.saveTask(newTask);

            response.sendRedirect(request.getContextPath() + "/task/list");
        } else {
            int taskId = Integer.parseInt(request.getParameter("task_id"));

            String description = request.getParameter("description");
            int priority = Integer.parseInt(request.getParameter("priority"));
            int status = Integer.parseInt(request.getParameter("status"));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date deadline = null;
            try {
                deadline = simpleDateFormat.parse(request.getParameter("deadline"));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            String responsibilities = request.getParameter("responsibilities");
            int assignedEmployeeId = Integer.parseInt(request.getParameter("assignedEmployee"));

            Task updatedTask = new Task();
            updatedTask.setTask_id(taskId);
            updatedTask.setDescription(description);
            updatedTask.setPriority(priority);
            updatedTask.setResponsibilities(responsibilities);
            updatedTask.setStatus(status);
            updatedTask.setDeadline(deadline);

            Employee assignedEmployee = employeeService.getEmployeeById(assignedEmployeeId);
            updatedTask.setAssignedEmployee(assignedEmployee);

            taskService.update(updatedTask);

            response.sendRedirect(request.getContextPath() + "/task/list");
        }
    }
}

