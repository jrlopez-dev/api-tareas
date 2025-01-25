package com.todoapp.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioDTO {
    private Long id;
    private String username;
    private String password;
    private String nombre;
    private List<TareaDTO> tareas;
}
