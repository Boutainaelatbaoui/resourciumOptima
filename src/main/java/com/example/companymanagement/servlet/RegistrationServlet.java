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

        if (fullName == null || fullName.matches("\\d+")) {
            request.getSession().setAttribute("error", "Full name must contain only letters (no numbers or special characters).");
            response.sendRedirect(request.getContextPath() + "/views/register.jsp?error=InvalidName");
            return;
        }

        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            request.getSession().setAttribute("error", "Invalid email format.");
            response.sendRedirect(request.getContextPath() + "/views/register.jsp?error=InvalidEmail");
            return;
        }

        if (password == null || password.length() < 8) {
            request.getSession().setAttribute("error", "Password must be at least 8 characters.");
            response.sendRedirect(request.getContextPath() + "/views/register.jsp?error=ShortPassword");
            return;
        }

        if (!password.equals(passwordConfirmation)) {
            request.getSession().setAttribute("error", "Password and confirmation do not match.");
            response.sendRedirect(request.getContextPath() + "/views/register.jsp?error=PasswordMismatch");
            return;
        }


        Employee newUser = new Employee();
        newUser.setFullName(fullName);
        newUser.setEmail(email);
        newUser.setPassword(password);

        entityManager.getTransaction().begin();
        entityManager.persist(newUser);
        entityManager.getTransaction().commit();

        request.getSession().removeAttribute("error");

        request.getSession().setAttribute("successMessage", "Employee registered successfully.");
        response.sendRedirect(request.getContextPath() + "/views/login.jsp");
    }

    public void destroy() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
