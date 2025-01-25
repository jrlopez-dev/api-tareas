package com.todoapp.controller;

import com.todoapp.model.dto.UsuarioDTO;
import com.todoapp.model.entity.Usuario;
import com.todoapp.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuaioController {
    @Autowired
    UsuariosService usuarioService;

    // Registrar un nuevo usuario
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> registerUser(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO nuevoUsuario = usuarioService.registerUser(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // Obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUserById(@PathVariable Long id) {
        Optional<UsuarioDTO> usuario = usuarioService.getUserById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getAllUsers() {
        List<UsuarioDTO> usuarios = usuarioService.getAllUsers();
        return ResponseEntity.ok(usuarios);
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usuarioService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
