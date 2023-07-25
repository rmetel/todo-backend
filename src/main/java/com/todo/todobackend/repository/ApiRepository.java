package com.todo.todobackend.repository;

import com.todo.todobackend.models.Api;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApiRepository extends JpaRepository<Api, Integer> {
    List<Api> findAll();
    Optional<Api> findById(int id);
    Optional<Api> findByDeployedTrue();
    Optional<Api> findByBranch(String branch);
}