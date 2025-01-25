package com.todoapp.service;

import com.todoapp.model.dto.TareaDTO;
import com.todoapp.model.dto.UsuarioDTO;
import com.todoapp.model.entity.Tarea;
import com.todoapp.model.entity.Usuario;
import com.todoapp.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TareasService {
    @Autowired
    TareaRepository tareaRepository;

    public TareaDTO guardarTareas(TareaDTO dto) {
        Tarea tarea = new Tarea();
        tarea = getTarea(dto);
        tareaRepository.save(tarea);
        dto.setId(dto.getId());
        return dto;
    }

    public List<TareaDTO> buscarTareasPorUsuario(Long userId) {
        List<Tarea> listaTareas = tareaRepository.findByUserId(userId);
        List<TareaDTO> listaTareasDTO = new ArrayList<>();
        if (listaTareas.isEmpty()) {
            for (Tarea tarea : listaTareas) {
                TareaDTO tareaDTO = new TareaDTO();
                tareaDTO = getTareaDTO(tarea);
                listaTareasDTO.add(tareaDTO);
            }
        }
        return listaTareasDTO;
    }

    public Optional<Tarea> buscarTareaPorID(Long id) {
        return tareaRepository.findById(id);
    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    public Tarea getTarea(TareaDTO dto) {
        Tarea tarea = new Tarea();
        tarea.setDescription(dto.getDescripcion());
        tarea.setTitle(dto.getTitulo());
        tarea.setIduser(dto.getIduser());
        return tarea;
    }

    public Usuario getUsuario(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setPassword(dto.getPassword());
        usuario.setUsername(dto.getUsername());
        return usuario;
    }

    public TareaDTO getTareaDTO(Tarea data) {
        TareaDTO tarea = new TareaDTO();
        tarea.setId(data.getId());
        tarea.setDescripcion(data.getDescription());
        tarea.setTitulo(data.getTitle());
        return tarea;
    }

    public UsuarioDTO getUsuarioDTO(Usuario data) {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setNombre(data.getNombre());
        usuario.setPassword(data.getPassword());
        usuario.setUsername(data.getUsername());
        return usuario;
    }

}
