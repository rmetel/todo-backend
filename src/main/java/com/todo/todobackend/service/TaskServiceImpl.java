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
    public void delete(Task task) {
        try {
            taskRepository.delete(task);
        } catch (Exception e) {

        }

    }

    @Override
    public Task update(Task task) {
        try {
            Optional<Task> existingTask = taskRepository.findById(task.getId());
            if(existingTask.isPresent()) {
                existingTask.get().setDescription(task.getDescription());
                existingTask.get().setDone(task.isDone());
                return taskRepository.save(existingTask.get());
            }
        } catch (Exception e) {

        }

        return null;
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
