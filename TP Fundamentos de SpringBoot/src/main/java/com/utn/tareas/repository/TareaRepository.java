package com.utn.tareas.repository;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {

    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicLong contador = new AtomicLong(1);

    public TareaRepository() {
        tareas.add(new Tarea(contador.getAndIncrement(), "Estudiar Spring Boot", false, Prioridad.ALTA));
        tareas.add(new Tarea(contador.getAndIncrement(), "Preparar café", true, Prioridad.BAJA));
        tareas.add(new Tarea(contador.getAndIncrement(), "Leer documentación", false, Prioridad.MEDIA));
    }

    public List<Tarea> obtenerTodas() {
        return tareas;
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareas.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public Tarea guardar(Tarea tarea) {
        tarea.setId(contador.getAndIncrement());
        tareas.add(tarea);
        return tarea;
    }

    public boolean eliminarPorId(Long id) {
        return tareas.removeIf(t -> t.getId().equals(id));
    }
}
