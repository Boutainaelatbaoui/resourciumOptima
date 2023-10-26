package com.example.companymanagement.service;

import com.example.companymanagement.entity.EquipmentCategory;
import com.example.companymanagement.repository.EmployeeRepository;
import com.example.companymanagement.repository.EquipmentCategoryRepository;
import com.example.companymanagement.repository.EquipmentReservationRepository;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EquipmentCategoryServiceTest {
    private EquipmentCategoryService equipmentCategoryService;
    private EquipmentCategoryRepository equipmentCategoryRepository ;

    @BeforeEach
    void setUp() {
        equipmentCategoryRepository = mock(EquipmentCategoryRepository.class);
        equipmentCategoryService = new EquipmentCategoryService(equipmentCategoryRepository);
    }

    @Test
    public void test_returns_all_equipment_categories_when_repository_has_data() {
        EquipmentCategoryRepository mockRepository = mock(EquipmentCategoryRepository.class);
        List<EquipmentCategory> expectedCategories = new ArrayList<>();
        expectedCategories.add(new EquipmentCategory());
        expectedCategories.add(new EquipmentCategory());
        when(equipmentCategoryRepository.AllEquipmentCateg()).thenReturn(expectedCategories);

        List<EquipmentCategory> result = equipmentCategoryService.getAllEquiCategory();

        assertEquals(expectedCategories, result);
    }

}