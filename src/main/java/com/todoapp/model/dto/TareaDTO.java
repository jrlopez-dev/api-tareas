package com.todoapp.model.dto;
import lombok.Data;

@Data
public class TareaDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private  Long iduser;

}
