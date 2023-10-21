package com.example.companymanagement.repository;

import com.example.companymanagement.entity.JobTitle;
import jakarta.persistence.*;

import java.util.List;

public class JobTitleRepository {
    private final EntityManagerFactory entityManagerFactory;
    public JobTitleRepository(){
        entityManagerFactory= Persistence.createEntityManagerFactory("default");
    }

    public void saveJobTitle(JobTitle jobTitle){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(jobTitle);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<JobTitle> getAllJobTitles() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            TypedQuery<JobTitle> query = entityManager.createQuery("SELECT j FROM JobTitle j", JobTitle.class);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

}
