package com.example.companymanagement.service;

import com.example.companymanagement.entity.*;
import com.example.companymanagement.repository.*;

import java.util.List;

public class EquipmentCategoryService {
    private final EquipmentCategoryRepository equipmentCategoryRepository;

    public EquipmentCategoryService() {
        equipmentCategoryRepository = new EquipmentCategoryRepository();
    }

    public List<EquipmentCategory> getAllEquiCategory() {
        return equipmentCategoryRepository.AllEquipmentCateg();
    }
}