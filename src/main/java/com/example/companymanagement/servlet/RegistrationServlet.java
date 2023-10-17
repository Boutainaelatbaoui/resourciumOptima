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
import java.util.Date;

@WebServlet(name = "RegistrationServlet", value = "/register")
public class RegistrationServlet extends HttpServlet {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public void init() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fullName = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("password_confirmation");

        if (password.equals(passwordConfirmation)) {
            Employee newUser = new Employee();
            newUser.setFullName(fullName);
            newUser.setEmail(email);
            newUser.setPassword(password);

            entityManager.getTransaction().begin();
            entityManager.persist(newUser);
            entityManager.getTransaction().commit();

            response.sendRedirect(request.getContextPath() + "/views/login.jsp");
        } else {
            response.sendRedirect(request.getContextPath() + "/views/register.jsp");
        }
    }

    public void destroy() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}