package com.example.companymanagement.entity;
import com.example.companymanagement.entity.enums.StatusEquipment;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
public class EquipmentReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservation_id;
    private Date reservation_date;

    private Date reservation_return;
    @Enumerated(EnumType.STRING)
    private StatusEquipment statusEquipment;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Date getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Date getReservation_return() {
        return reservation_return;
    }

    public void setReservation_return(Date reservation_return) {
        this.reservation_return = reservation_return;
    }

    public StatusEquipment getStatusEquipment() {
        return statusEquipment;
    }

    public void setStatusEquipment(StatusEquipment statusEquipment) {
        this.statusEquipment = statusEquipment;
    }
}