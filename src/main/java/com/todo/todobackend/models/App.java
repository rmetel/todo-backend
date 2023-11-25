package com.todo.todobackend.models;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class App {
    String branch;
    String version;
    boolean deployed;
}
