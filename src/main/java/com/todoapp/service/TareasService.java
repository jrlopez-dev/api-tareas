package com.todoapp.service;

import com.todoapp.model.entity.Tarea;
import com.todoapp.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareasService {
    @Autowired
    TareaRepository tareaRepository;

    public Tarea saveTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public List<Tarea> getTareasByUserId(Long userId) {
        return tareaRepository.findByUserId(userId);
    }

    public Optional<Tarea> getTareaById(Long id) {
        return tareaRepository.findById(id);
    }

    public void deleteTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}
