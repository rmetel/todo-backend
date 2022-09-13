package com.todo.todobackend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Task {
    int id;
    String description;
}
