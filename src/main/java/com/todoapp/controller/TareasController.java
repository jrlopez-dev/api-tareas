package com.todoapp.controller;

import com.todoapp.model.dto.TareaDTO;
import com.todoapp.service.TareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class TareasController {
    @Autowired
    private TareasService tareasService;

    @PostMapping("/guardar-tarea")
    public ResponseEntity generarArchivoMnt(@RequestBody TareaDTO dto) {
        return  ResponseEntity.ok(tareasService.guardarTareas(dto));
    }

    @GetMapping("/buscarTareas")
    public ResponseEntity buscarTareas(@RequestParam(name="id", required = false)Long id) {
        return  ResponseEntity.ok(tareasService.buscarTareasPorUsuario(id));
    }
}
