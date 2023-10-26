package com.example.companymanagement.service;

import com.example.companymanagement.entity.Employee;
import com.example.companymanagement.entity.JobTitle;
import com.example.companymanagement.repository.EmployeeRepository;
import com.example.companymanagement.repository.JobTitleRepository;
import jakarta.persistence.*;

import java.util.List;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
       this.employeeRepository = employeeRepository;
    }

    public EmployeeService( ) {
        employeeRepository = new EmployeeRepository();
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.AllEmployees();
    }
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

}

