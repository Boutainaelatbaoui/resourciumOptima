package com.example.companymanagement.service;

import com.example.companymanagement.entity.*;
import com.example.companymanagement.repository.*;

import java.util.List;

public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentService() {
        equipmentRepository = new EquipmentRepository();
    }
    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
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

    public Equipment getEquipmentById(int equipmentId){
        Equipment equipment = equipmentRepository.getEquipmentById(equipmentId);
        return equipment;
    }

}
