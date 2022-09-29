package com.todo.todobackend.controllers;

import com.todo.todobackend.models.Api;
import com.todo.todobackend.models.Task;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost", "http://localhost:8080", "http://localhost:3000", "http://localhost:5000"})
public class TaskController {
    /*@Autowired
    private TaskService taskService;*/

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
        return Arrays.asList(
                Task.builder()
                        .id(1)
                        .description("AWS")
                        .build(),
                Task.builder()
                        .id(2)
                        .description("Docker")
                        .build()
        );
    }

    @PostMapping("/tasks")
    @Operation(description = "Adds a new task")
    public Task addTask(@RequestBody Task task) {
        try {
//            taskService.addTask(task);
        } catch (Exception e) {
            return null;
        }
        return task;
    }

    @DeleteMapping("/tasks/{id}")
    @Operation(description = "Deletes a task")
    public boolean deleteTask(@PathVariable String id) {
        try {
//            Optional<Task> task = taskService.findById(Integer.parseInt(id));
//            task.ifPresent(value -> taskService.deleteTask(value));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /*@GetMapping("/tasks/{id}")
    public Optional<Task> getTaskById(@PathVariable String id) {
        return taskService.findById(Integer.parseInt(id));
    }*/
}
