package com.example.companymanagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int title_id;
    private String title_name;
    @OneToMany(mappedBy = "jobTitle")
    private List<Employee> employees;

    public JobTitle() {
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getTitle_id() {
        return title_id;
    }

    public void setTitle_id(int title_id) {
        this.title_id = title_id;
    }

    public String getTitle_name() {
        return title_name;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }
}
