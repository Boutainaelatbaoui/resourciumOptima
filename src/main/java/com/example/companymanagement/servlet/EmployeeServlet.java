package com.example.companymanagement.servlet;

import com.example.companymanagement.entity.Employee;
import com.example.companymanagement.entity.Equipment;
import com.example.companymanagement.entity.JobTitle;
import com.example.companymanagement.repository.EmployeeRepository;
import com.example.companymanagement.service.EmployeeService;
import com.example.companymanagement.service.JobTitleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = "/dashboard")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService;

    public void init() {
        employeeService = new EmployeeService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            int employeeId = Integer.parseInt(request.getParameter("id"));
            employeeService.deleteEmployee(employeeId);

            response.sendRedirect(request.getContextPath() + "/dashboard");
        } else {
            List<Employee> employees = employeeService.getAllEmployees();
            request.setAttribute("employees", employees);
            request.getRequestDispatcher("views/dashboard.jsp").forward(request, response);
        }
    }

}