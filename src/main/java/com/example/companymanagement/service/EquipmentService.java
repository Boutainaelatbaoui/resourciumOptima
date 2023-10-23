package com.example.companymanagement.service;

import com.example.companymanagement.entity.*;
import com.example.companymanagement.repository.*;

import java.util.List;

public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentService() {
        equipmentRepository = new EquipmentRepository();
    }

    public List<Equipment> getAllEquipment() {
        return equipmentRepository.AllEquipment();
    }
    public Equipment saveEquipment(Equipment equipment) {
        equipmentRepository.save(equipment);
        return equipment;
    }

    public void deleteEquipment(int id) {
        equipmentRepository.deleteEquipment(id);
    }

}
