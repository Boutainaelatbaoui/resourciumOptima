package com.example.companymanagement.service;

import com.example.companymanagement.entity.Employee;
import com.example.companymanagement.entity.Equipment;
import com.example.companymanagement.entity.Task;
import com.example.companymanagement.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskService( ) {
        taskRepository = new TaskRepository();
    }
    public Task saveTask(Task task) {
        taskRepository.save(task);
        return task;
    }
    public List<Task> getAllTask() {
        return taskRepository.AllTasks();
    }
    public void deleteTask(int id) {
        taskRepository.deleteTask(id);
    }
    public Task getTaskById(int taskId){
        Task task = taskRepository.getTaskById(taskId);
        return task;
    }

    public void update(Task task){
        taskRepository.update(task);
    }
}
