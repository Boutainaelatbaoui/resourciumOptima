package com.example.companymanagement.service;
import com.example.companymanagement.entity.JobTitle;
import com.example.companymanagement.repository.EquipmentRepository;
import com.example.companymanagement.repository.JobTitleRepository;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class JobTitleServiceTest {
    private JobTitleRepository jobTitleRepository;
    private JobTitleService jobTitleService;

    @BeforeEach
    void setUp() {
        jobTitleRepository = mock(JobTitleRepository.class);
        jobTitleService = new JobTitleService(jobTitleRepository);
    }

    @Test
    public void test_returns_all_job_titles_when_titles_exist() {
        List<JobTitle> expectedJobTitles = new ArrayList<>();
        expectedJobTitles.add(new JobTitle(1, "Title 1"));
        expectedJobTitles.add(new JobTitle(2, "Title 2"));
        when(jobTitleRepository.AllJobTitles()).thenReturn(expectedJobTitles);
        JobTitleService jobTitleService = new JobTitleService(jobTitleRepository);

        List<JobTitle> actualJobTitles = jobTitleService.getAllJobTitles();

        assertEquals(expectedJobTitles, actualJobTitles);
    }
}