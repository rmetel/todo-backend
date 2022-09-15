package com.todo.todobackend.controllers;

import com.todo.todobackend.models.Task;
import com.todo.todobackend.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class TaskController {
    int currentId = 1;

    Map<String, Task> tasks = new HashMap<>();

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    @Operation(description = "Gets all tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks/add")
    @Operation(description = "Adds a new task")
    public Task addTask(@RequestBody Task task) {
        try {
            taskService.addTask(task);
        } catch (Exception e) {
            return null;
        }
        return task;
    }

    /*@GetMapping("/{id}")
    public Optional<Wine> getWineById(@PathVariable String id){
        return wineService.findById(Integer.parseInt(id));
    }*/
}
