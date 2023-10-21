package com.example.companymanagement.servlet;

import com.example.companymanagement.entity.JobTitle;
import com.example.companymanagement.repository.JobTitleRepository;
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
    private JobTitleRepository jobTitleRepository;

    public void init() {
        jobTitleService = new JobTitleService();
        jobTitleRepository = new JobTitleRepository();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<JobTitle> jobTitles = jobTitleRepository.getAllJobTitles();

        request.setAttribute("jobTitles", jobTitles);

        request.getRequestDispatcher("views/register.jsp").forward(request, response);
    }
}
