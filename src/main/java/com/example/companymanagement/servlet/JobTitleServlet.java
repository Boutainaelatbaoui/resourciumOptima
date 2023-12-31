package com.example.companymanagement.servlet;

import com.example.companymanagement.entity.JobTitle;
import com.example.companymanagement.service.JobTitleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "JobTitleServlet", value = "/jobTitle")
public class JobTitleServlet extends HttpServlet {

    private JobTitleService jobTitleService;

    public void init() {
        jobTitleService = new JobTitleService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<JobTitle> jobTitles = jobTitleService.getAllJobTitles();

        request.setAttribute("jobTitles", jobTitles);

        request.getRequestDispatcher("views/register.jsp").forward(request, response);
    }
}
