package com.example.companymanagement;

import jakarta.persistence.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet", loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
    private String message;
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public void init() {
        message = "Hello World!";
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");

        if (entityManager.isOpen()) {
            out.println("<p>Database connection is successful!</p>");
        } else {
            out.println("<p>Failed to connect to the database.</p>");
        }

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
