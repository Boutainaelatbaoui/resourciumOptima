package com.example.companymanagement.servlet;

import com.example.companymanagement.entity.Employee;
import com.example.companymanagement.entity.JobTitle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e WHERE e.email = :email", Employee.class)
                .setParameter("email", email)
                .getResultList();

        if (employees.size() == 1) {
            Employee employee = employees.get(0);
            if (employee.getPassword().equals(password)) {
                request.getSession().setAttribute("username", employee.getFullName());
                JobTitle jobTitle = employee.getJobTitle();
                request.getSession().setAttribute("jobTitle", jobTitle.getTitle_name());
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/views/login.jsp");
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/views/login.jsp");
        }
    }

    public void destroy() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}

