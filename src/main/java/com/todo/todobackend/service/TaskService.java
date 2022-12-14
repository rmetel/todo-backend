package com.todo.todobackend.service;

import com.todo.todobackend.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task addTask(Task task);
    boolean deleteTask(Task task);
    Task updateTask(Task task);
    List<Task> getAllTasks();
    Optional<Task> findById(int id);
}
