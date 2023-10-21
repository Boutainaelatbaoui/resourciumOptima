package com.example.companymanagement.service;

import com.example.companymanagement.repository.JobTitleRepository;

public class JobTitleService {
    private final JobTitleRepository jobTitleRepository;

    public JobTitleService() {
        jobTitleRepository = new JobTitleRepository();
    }

}
