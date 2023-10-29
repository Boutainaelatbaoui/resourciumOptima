package com.example.companymanagement.repository;

import com.example.companymanagement.entity.Employee;
import com.example.companymanagement.entity.Equipment;
import com.example.companymanagement.entity.JobTitle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

    public void deleteEmployee(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Employee employee = entityManager.find(Employee.class, id);

        if (employee != null && "Employee".equals(employee.getJobTitle().getTitle_name())) {
            entityManager.getTransaction().begin();
            employee.setJobTitle(null);
            entityManager.remove(employee);
            entityManager.getTransaction().commit();
        }

        entityManager.close();
    }

    public Employee getEmployeeById(int employeeId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Employee.class, employeeId);
        } finally {
            entityManager.close();
        }
    }

}
