package com.example.companymanagement.servlet;

import com.example.companymanagement.model.Employee;
import jakarta.persistence.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.example.companymanagement.service.EmployeeService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    private String message;
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;
    private EmployeeService employeeService;

    public void init() {
        message = "Hello World!";
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        employeeService = new EmployeeService(entityManager);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        if (entityManager.isOpen()) {
            out.println("<p>Database connection is successful!</p>");
        } else {
            out.println("<p>Failed to connect to the database.</p>");
        }

        Employee employee = new Employee();
        employee.setFullName("Joe");
        employee.setEmail("joe@gmail.com");
        employee.setPassword("123 Main St");
        employee.setTelephone("555-123-4567");
        employee.setSalary(50000.0);

        employeeService.createEmployee(employee);

        out.println("<p>Employee created and saved to the database.</p>");

        entityManager.close();
        entityManagerFactory.close();

        out.println("</body></html>");
    }

    public void destroy() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
        }
    }
}
