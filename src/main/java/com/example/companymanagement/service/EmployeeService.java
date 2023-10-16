package com.example.companymanagement.service;

import com.example.companymanagement.model.Employee;
import jakarta.persistence.*;

public class EmployeeService {
    private EntityManager entityManager;

    public EmployeeService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createEmployee(Employee employee) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(employee);
        transaction.commit();
    }
}

