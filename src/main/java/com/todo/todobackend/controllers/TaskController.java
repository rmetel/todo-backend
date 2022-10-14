package com.todo.todobackend.controllers;

import com.todo.todobackend.models.Api;
import com.todo.todobackend.models.Task;
import com.todo.todobackend.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {
        "http://localhost",
        "http://localhost:80",
        "http://localhost:81",
        "http://localhost:8080",
        "http://localhost:3000",
        "http://localhost:5000",
        "http://todo-app.eu-central-1.elasticbeanstalk.com/", // AWS
        "http://212.227.201.99:81" // IONOS
})
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    BuildProperties buildProperties;

    @GetMapping("/version")
    @Operation(description = "Gets api version")
    public Api getVersion() {
        return Api.builder()
                .version(buildProperties.getVersion())
                .build();
    }

    @GetMapping("/tasks")
    @Operation(description = "Gets all tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks")
    @Operation(description = "Adds a new task")
    public Task addTask(@RequestBody Task task) {
        try {
            taskService.addTask(task);
        } catch (Exception e) {
            return null;
        }
        return task;
    }

    @DeleteMapping("/tasks/{id}")
    @Operation(description = "Deletes a task")
    public boolean deleteTask(@PathVariable String id) {
        try {
            Optional<Task> task = taskService.findById(Integer.parseInt(id));
            task.ifPresent(value -> taskService.deleteTask(value));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @GetMapping("/tasks/{id}")
    public Optional<Task> getTaskById(@PathVariable String id) {
        return taskService.findById(Integer.parseInt(id));
    }

    @PutMapping("tasks/{id}")
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }
}
