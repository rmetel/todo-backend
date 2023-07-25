package com.todo.todobackend.service;

import com.todo.todobackend.models.Api;
import com.todo.todobackend.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    private ApiRepository apiRepository;

    @Override
    public void add(Api api) {
        apiRepository.save(api);
    }

    @Override
    public Api update(Api updatedApi) {
        try {
            Optional<Api> api = apiRepository.findById(updatedApi.getId());
            if(api.isPresent()) {
                return apiRepository.save(updatedApi);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public void delete(Api api) {
        try {
            apiRepository.delete(api);
        } catch (Exception ignored) {

        }
    }

    @Override
    public List<Api> findAll() {
        return apiRepository.findAll();
    }

    @Override
    public Optional<Api> findById(int id) {
        return apiRepository.findById(id);
    }

    @Override
    public Optional<Api> findByDeployedTrue() {
        return apiRepository.findByDeployedTrue();
    }

    @Override
    public Optional<Api> findByBranch(String branch) {
        return apiRepository.findByBranch(branch);
    }
}
