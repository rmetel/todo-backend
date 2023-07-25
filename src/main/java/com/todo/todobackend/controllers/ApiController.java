package com.todo.todobackend.controllers;

import com.todo.todobackend.models.Api;
import com.todo.todobackend.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
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
        "http://212.227.201.99", // IONOS
        "http://todo-app.tech/" // IONOS
})
public class ApiController {
    @Autowired
    private ApiService apiService;

    @GetMapping("/versions")
    public List<Api> getAll() {
        return apiService.findAll();
    }

    @GetMapping("/version")
    public Api getDeployedVersion() {
        Optional<Api> api;
        try {
            api = apiService.findByDeployedTrue();
        } catch (Exception e) {
            return null;
        }
        return api.orElse(Api.builder()
                .branch("unknown version")
                .build());
    }

    @PostMapping("/version")
    public Api add(@RequestBody Api api) {
        try {
            apiService.add(api);
        } catch (Exception e) {
            return null;
        }
        return api;
    }

    @PutMapping("/version")
    public Api update(@RequestBody Api api) {
        return apiService.update(api);
    }

    @DeleteMapping("/version/{id}")
    public boolean delete(@PathVariable String id) {
        try {
            Optional<Api> api = apiService.findById(Integer.parseInt(id));
            api.ifPresent(value -> apiService.delete(value));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @GetMapping("/version/{branch}")
    public Optional<Api> getByBranch(@PathVariable String branch) {
        return apiService.findByBranch(branch);
    }
}
