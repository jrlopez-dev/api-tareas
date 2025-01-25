package com.todoapp.service;

import com.todoapp.model.dto.UsuarioDTO;
import com.todoapp.model.entity.Usuario;
import com.todoapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioDTO registerUser(UsuarioDTO data) {
        System.out.println("Entro al metodo a registrar usuario");
        Usuario usuario = new Usuario();
        usuario.setNombre(data.getNombre());
        usuario.setUsername(data.getUsername());
        usuario.setPassword(data.getPassword());
        usuario = usuarioRepository.save(usuario);
        data.setId(usuario.getId());
        return data;

    }

    public Optional<UsuarioDTO> getUserByUsername(String username) {
        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        if (usuario.isPresent()) {
            usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.get().getId());
            usuarioDTO.setNombre(usuario.get().getNombre());
            usuarioDTO.setUsername(usuario.get().getUsername());
            usuarioDTO.setPassword(usuario.get().getPassword());
            return Optional.of(usuarioDTO);
        }
        return Optional.of(usuarioDTO);
    }

    public Optional<UsuarioDTO> getUserById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        if (usuario.isPresent()) {
            usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId(usuario.get().getId());
            usuarioDTO.setNombre(usuario.get().getNombre());
            usuarioDTO.setUsername(usuario.get().getUsername());
            usuarioDTO.setPassword(usuario.get().getPassword());
            return Optional.of(usuarioDTO);
        }
        return Optional.of(usuarioDTO);
    }

    public List<UsuarioDTO> getAllUsers() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        if (!usuarios.isEmpty()) {
            for (Usuario usuario : usuarios) {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setId(usuario.getId());
                usuarioDTO.setNombre(usuario.getNombre());
                usuarioDTO.setUsername(usuario.getUsername());
                usuariosDTO.add(usuarioDTO);
            }
        }
        return usuariosDTO;
    }

    public void deleteUser(Long id) {
        usuarioRepository.deleteById(id);
    }
}
