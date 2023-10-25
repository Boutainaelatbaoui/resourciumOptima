package com.example.companymanagement.servlet;

import com.example.companymanagement.entity.*;
import com.example.companymanagement.entity.enums.StatusEquipment;
import com.example.companymanagement.service.*;
import jakarta.persistence.criteria.CriteriaBuilder;
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

@WebServlet(name = "EquipmentReservationServlet", value = "/reservation")
public class EquipmentReservationServlet extends HttpServlet {
    private EquipmentService equipmentService;
    private EquipmentCategoryService equipmentCategoryService;

    public void init() {
        equipmentService = new EquipmentService();
        equipmentCategoryService = new EquipmentCategoryService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String equipmentIdParam = request.getParameter("id");
        if (equipmentIdParam != null) {
            int equipmentId = Integer.parseInt(equipmentIdParam);

            Equipment equipment = equipmentService.getEquipmentById(equipmentId);

            if (equipment != null) {
                request.setAttribute("equipment", equipment);
                request.getRequestDispatcher("/views/updateEquipmentReservation.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/equipment/list");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String reservationReturnDate = request.getParameter("reservationReturn");

            EquipmentReservation equipmentReservation = new EquipmentReservation();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date returnDate = dateFormat.parse(reservationReturnDate);

            Integer newEquipment = Integer.parseInt(request.getParameter("equipment"));

            Equipment equipment = equipmentService.getEquipmentById(newEquipment);

            HttpSession session = request.getSession();
            Employee loggedInEmployee = (Employee) session.getAttribute("employee");

            equipmentReservation.setReservation_date(new Date());
            equipmentReservation.setReservation_return(returnDate);
            equipmentReservation.setStatusEquipment(StatusEquipment.InUse);
            equipmentReservation.setEquipment(equipment);
            equipmentReservation.setEmployee(loggedInEmployee);

            EquipmentReservationService reservationService = new EquipmentReservationService();
            reservationService.saveEquipmentReservation(equipmentReservation);

            response.sendRedirect(request.getContextPath() + "/equipment/list");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
