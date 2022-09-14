package com.todo.todobackend.controllers;

import com.todo.todobackend.models.Task;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class TaskController {
    int currentId = 1;

    Map<String, Task> tasks = new HashMap<>();

    /*@Autowired
    private WineService wineService;*/

    @GetMapping("/tasks")
    @Operation(description = "Gets all tasks")
    public List<Task> getAllTasks() {
        List<Task> taskList = new ArrayList<>();

        for(Map.Entry<String, Task> task : tasks.entrySet()) {
            taskList.add(task.getValue());
        }

        return taskList;
    }

    @PostMapping("/tasks/add")
    @Operation(description = "Adds a new task")
    public Task addTask(@RequestBody Task task) {
        try {
            task.setId(currentId);
            tasks.put(String.valueOf(currentId), task);
            currentId++;
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
