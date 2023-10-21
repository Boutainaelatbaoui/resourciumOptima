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
import java.util.List;

@WebServlet(name = "EquipmentCategoryServlet", value = "/create-equi")
public class EquipmentCategoryServlet extends HttpServlet {

    private EquipmentCategoryService equipmentCategoryService;

    public void init() {
        equipmentCategoryService = new EquipmentCategoryService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EquipmentCategory> equipmentCategories = equipmentCategoryService.getAllEquiCategory();

        request.setAttribute("equipmentCategories", equipmentCategories);

        request.getRequestDispatcher("views/createEquipment.jsp").forward(request, response);
    }

}
