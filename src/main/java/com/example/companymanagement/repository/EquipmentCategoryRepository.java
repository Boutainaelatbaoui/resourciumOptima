package com.example.companymanagement.repository;

import com.example.companymanagement.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EquipmentCategoryRepository {
    private final EntityManagerFactory entityManagerFactory;

    public EquipmentCategoryRepository(){
        entityManagerFactory= Persistence.createEntityManagerFactory("default");
    }

    public List<EquipmentCategory> AllEquipmentCateg() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<EquipmentCategory> query = entityManager.createQuery("SELECT e FROM EquipmentCategory e", EquipmentCategory.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
    public EquipmentCategory findById(int categoryId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(EquipmentCategory.class, categoryId);
        } finally {
            entityManager.close();
        }
    }

}
