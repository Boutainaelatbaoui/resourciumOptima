package com.example.companymanagement.servlet;

import com.example.companymanagement.model.Employee;
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

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e WHERE e.email = :email AND e.password = :password", Employee.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList();

        if (employees.size() == 1) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
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

