package com.example.companymanagement.service;

import com.example.companymanagement.entity.Employee;
import com.example.companymanagement.entity.JobTitle;
import com.example.companymanagement.repository.EmployeeRepository;
import com.example.companymanagement.service.EmployeeService;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        employeeRepository = mock(EmployeeRepository.class);
        employeeService = new EmployeeService(employeeRepository);
    }

    @Test
    void testGetAllEmployees() {

        Employee employee = new Employee();
        JobTitle jobTitle = new JobTitle();
        jobTitle.setTitle_id(1);
        jobTitle.setTitle_name("Manager");
        employee.setId(1L);
        employee.setFullName("Boutaina");
        employee.setEmail("boutaina@gmail.com");
        employee.setPassword("12345678");
        employee.setJobTitle(jobTitle);

        Employee e = new Employee();

        Employee employee1 = new Employee();
        JobTitle jobTitle1 = new JobTitle();
        jobTitle1.setTitle_id(2);
        jobTitle1.setTitle_name("Employee");
        employee1.setId(2L);
        employee1.setFullName("noha");
        employee1.setEmail("nouhaila@gmail.com");
        employee1.setPassword("12345678");
        employee1.setJobTitle(jobTitle);

        List<Employee> expectedEmployees = Arrays.asList(employee, employee1);

        when(employeeRepository.AllEmployees()).thenReturn(expectedEmployees);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(expectedEmployees, result);
    }

    @Test
    void testDeleteEmployee() {
        int employeeId = 1;

        employeeService.deleteEmployee(employeeId);

        verify(employeeRepository, times(1)).deleteEmployee(employeeId);
    }


}
