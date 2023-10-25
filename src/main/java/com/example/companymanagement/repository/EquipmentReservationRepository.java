package com.example.companymanagement.repository;
import com.example.companymanagement.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.*;

public class EquipmentReservationRepository {
    private final EntityManagerFactory entityManagerFactory;

    public EquipmentReservationRepository(){
        entityManagerFactory= Persistence.createEntityManagerFactory("default");
    }
    public void save(EquipmentReservation equipmentReservation){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(equipmentReservation);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
