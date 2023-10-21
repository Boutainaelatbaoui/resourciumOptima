package com.example.companymanagement.repository;

import com.example.companymanagement.entity.Employee;
import com.example.companymanagement.entity.JobTitle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EmployeeRepository {
    private final EntityManagerFactory entityManagerFactory;

    public EmployeeRepository(){
        entityManagerFactory= Persistence.createEntityManagerFactory("default");
    }

    public List<Employee> AllEmployees() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }
}
