package com.example.companymanagement.service;

import com.example.companymanagement.entity.EquipmentCategory;
import com.example.companymanagement.repository.*;

import java.util.List;

public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public EquipmentService() {
        equipmentRepository = new EquipmentRepository();
    }

    public List<EquipmentCategory> getAllEquiCategory() {
        return equipmentRepository.AllEquipmentCateg();
    }
}
