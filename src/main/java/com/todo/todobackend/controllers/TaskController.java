package com.todo.todobackend.controllers;

import com.todo.todobackend.models.Task;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class TaskController {
    /*@Autowired
    private WineService wineService;*/

    /*@PostMapping("/add")
    public boolean addWine(@RequestBody Wine wine) {
        try {
            wineService.addWine(wine);
        } catch (Exception e) {
            return false;
        }
        return true;
    }*/

    @GetMapping("/all")
    public List<Task> getAllTasks() {
        return Arrays.asList(
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
        );
    }

    /*@GetMapping("/{id}")
    public Optional<Wine> getWineById(@PathVariable String id){
        return wineService.findById(Integer.parseInt(id));
    }*/
}
