package com.todo.todobackend.service;

import com.todo.todobackend.models.Task;
import com.todo.todobackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void add(Task task) {
        taskRepository.save(task);
    }

    @Override
    public Task update(Task updatedTask) {
        try {
            Optional<Task> task = taskRepository.findById(updatedTask.getId());
            if(task.isPresent()) {
                return taskRepository.save(updatedTask);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public void delete(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(int id) {
        return taskRepository.findById(id);
    }

}
