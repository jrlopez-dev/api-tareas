package com.todoapp.controller;

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
    public ResponseEntity<Usuario> registerUser(@RequestBody Usuario usuario) {
        Optional<Usuario> existente = usuarioService.getUserByUsername(usuario.getUsername());
        if (existente.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        Usuario nuevoUsuario = usuarioService.registerUser(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    // Obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.getUserById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers() {
        List<Usuario> usuarios = usuarioService.getAllUsers();
        return ResponseEntity.ok(usuarios);
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usuarioService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
