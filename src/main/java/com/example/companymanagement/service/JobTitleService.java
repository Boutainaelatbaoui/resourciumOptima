package com.example.companymanagement.service;

import com.example.companymanagement.entity.JobTitle;
import com.example.companymanagement.repository.JobTitleRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JobTitleService {
    private final JobTitleRepository jobTitleRepository;

    public JobTitleService() {
        jobTitleRepository = new JobTitleRepository();
    }
    public JobTitleService(JobTitleRepository jobTitleRepository) {
        this.jobTitleRepository = jobTitleRepository;
    }

    public List<JobTitle> getAllJobTitles() {
        return jobTitleRepository.AllJobTitles();
    }

}
