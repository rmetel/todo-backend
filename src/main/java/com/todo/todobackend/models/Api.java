package com.todo.todobackend.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "api")
public class Api {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    String branch;
    String version;
    boolean deployed;
}
