package com.example.companymanagement.service;

import com.example.companymanagement.entity.Equipment;
import com.example.companymanagement.entity.EquipmentCategory;
import com.example.companymanagement.repository.EquipmentRepository;
import com.example.companymanagement.repository.EquipmentReservationRepository;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EquipmentServiceTest {
    private EquipmentRepository equipmentRepository;
    private EquipmentService equipmentService;

    @BeforeEach
    void setUp() {
        equipmentRepository = mock(EquipmentRepository.class);
        equipmentService = new EquipmentService(equipmentRepository);
    }

    @Test
    public void test_returns_all_equipment() {
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(new Equipment());
        when(equipmentRepository.AllEquipment()).thenReturn(equipmentList);

        List<Equipment> result = equipmentService.getAllEquipment();

        assertEquals(equipmentList, result);
    }

    @Test
    public void test_returns_null_when_result_list_is_null() {
        when(equipmentRepository.AllEquipment()).thenReturn(null);

        List<Equipment> result = equipmentService.getAllEquipment();

        assertNull(result);
    }

    @Test
    public void test_saves_new_equipment() {
        Equipment equipment = new Equipment();

        equipmentService.saveEquipment(equipment);

        verify(equipmentRepository).save(equipment);
    }

    @Test
    public void test_returns_saved_equipment() {
        Equipment equipment = new Equipment();

        Equipment savedEquipment = equipmentService.saveEquipment(equipment);

        assertEquals(equipment, savedEquipment);
    }

    @Test
    public void test_deleteEquipment() {
        int id = 1;

        equipmentService.deleteEquipment(id);

        verify(equipmentRepository, times(1)).deleteEquipment(id);
    }

    @Test
    public void test_getEquipmentById_exists() {
        int equipmentId = 1;
        Equipment expectedEquipment = new Equipment();
        when(equipmentRepository.getEquipmentById(equipmentId)).thenReturn(expectedEquipment);

        Equipment result = equipmentService.getEquipmentById(equipmentId);

        assertEquals(expectedEquipment, result);
        verify(equipmentRepository).getEquipmentById(equipmentId);
    }

    @Test
    public void test_getEquipmentById_notExists() {
        int equipmentId = 1;
        when(equipmentRepository.getEquipmentById(equipmentId)).thenReturn(null);

        Equipment result = equipmentService.getEquipmentById(equipmentId);

        assertNull(result);
        verify(equipmentRepository).getEquipmentById(equipmentId);
    }

}