package com.todo.todobackend.service;

import com.todo.todobackend.models.Api;

import java.util.List;
import java.util.Optional;

public interface ApiService {
    void add(Api api);

    Api update(Api api);

    void delete(Api api);

    List<Api> findAll();

    Optional<Api> findById(int id);

    Optional<Api> findByDeployedTrue();

    Optional<Api> findByBranch(String branch);
}
