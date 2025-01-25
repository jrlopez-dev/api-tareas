package com.todoapp.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private  Long iduser;
}
