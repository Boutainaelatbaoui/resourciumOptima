package com.example.companymanagement.service;

import com.example.companymanagement.entity.Equipment;
import com.example.companymanagement.entity.EquipmentReservation;
import com.example.companymanagement.repository.*;

public class EquipmentReservationService {
    private final EquipmentReservationRepository equipmentReservationRepository;

    public EquipmentReservationService() {
        equipmentReservationRepository = new EquipmentReservationRepository();
    }
    public EquipmentReservation saveEquipmentReservation(EquipmentReservation equipmentReservation) {
        equipmentReservationRepository.save(equipmentReservation);
        return equipmentReservation;
    }
}
