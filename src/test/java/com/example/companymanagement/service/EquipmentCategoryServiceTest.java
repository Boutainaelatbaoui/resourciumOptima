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
    public void test_returns_all_equipment_categories() {
        EquipmentCategoryRepository mockRepository = mock(EquipmentCategoryRepository.class);
        List<EquipmentCategory> expectedCategories = new ArrayList<>();
        expectedCategories.add(new EquipmentCategory());
        expectedCategories.add(new EquipmentCategory());
        when(equipmentCategoryRepository.AllEquipmentCateg()).thenReturn(expectedCategories);

        List<EquipmentCategory> result = equipmentCategoryService.getAllEquiCategory();

        assertEquals(expectedCategories, result);
    }

    @Test
    public void test_returns_null_when_query_result_is_null() {
        when(equipmentCategoryRepository.AllEquipmentCateg()).thenReturn(null);

        List<EquipmentCategory> result = equipmentCategoryService.getAllEquiCategory();

        assertNull(result);
    }

    @Test
    public void test_returns_equipment_category_with_given_category_id() {
        int categoryId = 1;

        EquipmentCategory result = new EquipmentCategoryService().getCategoryById(categoryId);

        assertNotNull(result);
        assertEquals(categoryId, result.getCategory_id());
    }

    @Test
    public void test_returns_null_if_no_equipment_category_found_with_given_category_id() {
        int categoryId = 100;

        EquipmentCategory result = new EquipmentCategoryService().getCategoryById(categoryId);

        assertNull(result);
    }

}