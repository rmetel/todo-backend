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
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public boolean deleteTask(Task task) {
        try {
            taskRepository.delete(task);
            return true;
        } catch (Exception e) {

        }

        return false;
    }

    @Override
    public Task updateTask(Task task) {
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
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findById(int id) {
        return taskRepository.findById(id);
    }

}
