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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@WebServlet(name = "EquipmentServlet", value = {"/equipment/list", "/equipment/create", "/equipment/update", "/equipment/delete"})
public class EquipmentServlet extends HttpServlet {
    private EquipmentService equipmentService;
    private EquipmentCategoryService equipmentCategoryService;

    public void init() {
        equipmentService = new EquipmentService();
        equipmentCategoryService = new EquipmentCategoryService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Equipment> equipments = equipmentService.getAllEquipment();

        request.setAttribute("equipments", equipments);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String name = request.getParameter("name");
            double cost = Double.parseDouble(request.getParameter("cost"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            String dateOfPurchaseStr = request.getParameter("purchase");
            String dateOfMaintenanceStr = request.getParameter("maintenance");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate dateOfPurchase = LocalDate.parse(dateOfPurchaseStr, formatter);
            LocalDate dateOfMaintenance = LocalDate.parse(dateOfMaintenanceStr, formatter);

            int categoryId = Integer.parseInt(request.getParameter("category"));

            Equipment newEquipment = new Equipment();
            newEquipment.setName(name);
            newEquipment.setCost(cost);
            newEquipment.setQuantity(quantity);
            newEquipment.setDate_of_purchase(java.sql.Date.valueOf(dateOfPurchase));
            newEquipment.setDate_of_maintenance(java.sql.Date.valueOf(dateOfMaintenance));

            EquipmentCategory category = equipmentCategoryService.getCategoryById(categoryId);
            newEquipment.setEquipmentCategory(category);

            equipmentService.saveEquipment(newEquipment);
            response.sendRedirect(request.getContextPath() + "/views/equipment.jsp");
        }
    }
}

