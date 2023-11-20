package com.todo.todobackend.controllers;

import com.todo.todobackend.models.Task;
import com.todo.todobackend.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {
        "http://localhost",
        "http://localhost:80",
        "http://localhost:8080",
        "http://localhost:3000",
        "https://localhost",
        "https://localhost:443",
        "http://212.227.201.99",
        "https://212.227.201.99",
        "http://todo-app.tech/",
        "https://todo-app.tech/"
})
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAll() {
        return taskService.findAll();
    }

    @GetMapping("/tasks/{id}")
    public Optional<Task> getById(@PathVariable String id) {
        return taskService.findById(Integer.parseInt(id));
    }

    @PostMapping("/tasks")
    public Task add(@RequestBody Task task) {
        try {
            taskService.add(task);
        } catch (Exception e) {
            return null;
        }
        return task;
    }

    @PutMapping("tasks/{id}")
    public Task update(@RequestBody Task task) {
        return taskService.update(task);
    }

    @DeleteMapping("/tasks/{id}")
    @Operation(description = "Deletes a task")
    public boolean delete(@PathVariable String id) {
        try {
            Optional<Task> task = taskService.findById(Integer.parseInt(id));
            task.ifPresent(value -> taskService.delete(value));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
