package com.example.companymanagement.entity;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int equipment_id;
    private String name;
    private double cost;
    private int quantity;
    private Date date_of_purchase;
    private Date date_of_maintenance;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private EquipmentCategory equipmentCategory;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.REMOVE)
    private List<EquipmentReservation> equipmentReservations;

    public List<EquipmentReservation> getEquipmentReservations() {
        return equipmentReservations;
    }

    public void setEquipmentReservations(List<EquipmentReservation> equipmentReservations) {
        this.equipmentReservations = equipmentReservations;
    }

    public EquipmentCategory getEquipmentCategory() {
        return equipmentCategory;
    }

    public void setEquipmentCategory(EquipmentCategory equipmentCategory) {
        this.equipmentCategory = equipmentCategory;
    }

    public int getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate_of_purchase() {
        return date_of_purchase;
    }

    public void setDate_of_purchase(Date date_of_purchase) {
        this.date_of_purchase = date_of_purchase;
    }

    public Date getDate_of_maintenance() {
        return date_of_maintenance;
    }

    public void setDate_of_maintenance(Date date_of_maintenance) {
        this.date_of_maintenance = date_of_maintenance;
    }
}
