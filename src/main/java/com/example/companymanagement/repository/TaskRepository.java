package com.example.companymanagement.repository;

import com.example.companymanagement.entity.Employee;
import com.example.companymanagement.entity.Equipment;
import com.example.companymanagement.entity.Task;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TaskRepository {
    private final EntityManagerFactory entityManagerFactory;

    public TaskRepository(){
        entityManagerFactory= Persistence.createEntityManagerFactory("default");
    }
    public void save(Task task){
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public List<Task> AllTasks() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<Task> query = entityManager.createQuery("SELECT e FROM Task e", Task.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public void deleteTask(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Task task = entityManager.find(Task.class, id);

        if (task != null) {
            entityManager.getTransaction().begin();
            task.setAssignedEmployee(null);
            entityManager.remove(task);
            entityManager.getTransaction().commit();
        }

        entityManager.close();
    }

    public Task getTaskById(int taskId){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            return entityManager.find(Task.class, taskId);
        } finally {
            entityManager.close();
        }
    }

    public void update(Task task){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(task);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
