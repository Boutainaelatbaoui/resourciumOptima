package com.example.companymanagement.repository;

import com.example.companymanagement.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EquipmentRepository {
    private final EntityManagerFactory entityManagerFactory;

    public EquipmentRepository(){
        entityManagerFactory= Persistence.createEntityManagerFactory("default");
    }

    public List<Equipment> AllEquipment() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Equipment> query = entityManager.createQuery("SELECT e FROM Equipment e", Equipment.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void save(Equipment equipment){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(equipment);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
