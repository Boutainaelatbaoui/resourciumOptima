package com.example.companymanagement.service;

import com.example.companymanagement.entity.Employee;
import com.example.companymanagement.entity.Equipment;
import com.example.companymanagement.entity.EquipmentReservation;
import com.example.companymanagement.entity.enums.StatusEquipment;
import com.example.companymanagement.repository.EmployeeRepository;
import com.example.companymanagement.repository.EquipmentCategoryRepository;
import com.example.companymanagement.repository.EquipmentRepository;
import com.example.companymanagement.repository.EquipmentReservationRepository;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EquipmentReservationServiceTest {
    private EquipmentReservationRepository equipmentReservationRepository;
    private EquipmentReservationService equipmentReservationService;

    @BeforeEach
    void setUp() {
        equipmentReservationRepository = mock(EquipmentReservationRepository.class);
        equipmentReservationService = new EquipmentReservationService(equipmentReservationRepository);
    }

    @Test
    public void test_save_equipment_reservation() {
        EquipmentReservation equipmentReservation = new EquipmentReservation();
        equipmentReservation.setReservation_id(1);
        equipmentReservation.setReservation_date(new Date());
        equipmentReservation.setReservation_return(new Date());
        equipmentReservation.setStatusEquipment(StatusEquipment.InUse);
        Employee employee = new Employee();
        employee.setId(1L);
        equipmentReservation.setEmployee(employee);
        Equipment equipment = new Equipment();
        equipment.setEquipment_id(1);
        equipmentReservation.setEquipment(equipment);

        EquipmentReservation savedReservation = equipmentReservationService.saveEquipmentReservation(equipmentReservation);

        assertNotNull(savedReservation);
        assertEquals(equipmentReservation, savedReservation);
    }

    @Test
    public void test_return_all_reservations() {
        List<EquipmentReservation> expectedReservations = new ArrayList<>();
        expectedReservations.add(new EquipmentReservation());
        expectedReservations.add(new EquipmentReservation());
        when(equipmentReservationRepository.AllReservations()).thenReturn(expectedReservations);

        EquipmentReservationService service = new EquipmentReservationService(equipmentReservationRepository);

        List<EquipmentReservation> actualReservations = equipmentReservationService.getAllReservations();

        assertEquals(expectedReservations, actualReservations);
    }

}