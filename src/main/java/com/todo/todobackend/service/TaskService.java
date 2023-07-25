package com.todo.todobackend.service;

import com.todo.todobackend.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    void add(Task task);

    Task update(Task task);

    void delete(Task task);

    List<Task> findAll();

    Optional<Task> findById(int id);
}
