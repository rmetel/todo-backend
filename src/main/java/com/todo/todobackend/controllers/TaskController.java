package com.todo.todobackend.controllers;

import com.todo.todobackend.models.Api;
import com.todo.todobackend.models.Task;
import com.todo.todobackend.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:3000"})
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/version")
    @Operation(description = "Gets api version")
    private Api getVersion() throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader("pom.xml"));
        return Api.builder()
                .version(model.getVersion())
                .build();
    }

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

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable String id){
        return taskService.findById(Integer.parseInt(id));
    }
}
