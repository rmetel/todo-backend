package com.todo.todobackend.controllers;

import com.todo.todobackend.models.Task;
//import io.swagger.annotations.ApiOperation;
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

    @PostMapping("/tasks/add")
//    @ApiOperation(value = "adds a new task", httpMethod = "POST")
    public boolean addTask(@RequestBody Task task) {
        try {
            task.setId(currentId);
            tasks.put(String.valueOf(currentId), task);
            currentId++;
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @GetMapping("/tasks")
//    @ApiOperation(value = "retrieves all available tasks", httpMethod = "GET")
    public List<Task> getAllTasks() {
        List<Task> taskList = new ArrayList<>();

        for(Map.Entry<String, Task> task : tasks.entrySet()) {
            taskList.add(task.getValue());
        }

        return taskList;
        /*return Arrays.asList(
                Task.builder()
                        .id(1)
                        .description("Java SE 11 Developer Certification (1Z0-819)")
                        .build(),
                Task.builder()
                        .id(2)
                        .description("Certified Kubernetes Application Developer (CKAD)")
                        .build(),
                Task.builder()
                        .id(3)
                        .description("AWS Certified Developer - Associate")
                        .build()
        );*/
    }

    /*@GetMapping("/{id}")
    public Optional<Wine> getWineById(@PathVariable String id){
        return wineService.findById(Integer.parseInt(id));
    }*/
}
