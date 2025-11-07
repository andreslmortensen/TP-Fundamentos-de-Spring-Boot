package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class TareaService {
    private final TareaRepository tareaRepository;

    @Value("${app.nombre:Gestor de Tareas}")
    private String nombreApp;

    @Value("${app.max-tareas:100}")
    private int maxTareas;

    @Getter
    @Value("${app.mostrar-estadisticas:true}")
    private boolean mostrarEstadisticas;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea agregarTarea(String descripcion, Prioridad prioridad) {
        List<Tarea> todas = tareaRepository.obtenerTodas();
        if (todas.size() >= maxTareas) {
            throw new RuntimeException("Se alcanzó el máximo de tareas permitidas (" + maxTareas + ")");
        }

        Tarea nueva = new Tarea(null, descripcion, false, prioridad);
        return tareaRepository.guardar(nueva);
    }

    public List<Tarea> listarTodas() {
        return tareaRepository.obtenerTodas();
    }

    public List<Tarea> listarPendientes() {
        return tareaRepository.obtenerTodas()
                .stream()
                .filter(t -> !t.isCompletada())
                .collect(Collectors.toList());
    }

    public List<Tarea> listarCompletadas() {
        return tareaRepository.obtenerTodas()
                .stream()
                .filter(Tarea::isCompletada)
                .collect(Collectors.toList());
    }

    public void marcarComoCompletada(Long id) {
        tareaRepository.buscarPorId(id).ifPresent(t -> t.setCompletada(true));
    }

    public String obtenerEstadisticas() {
        List<Tarea> todas = tareaRepository.obtenerTodas();
        long completadas = todas.stream().filter(Tarea::isCompletada).count();
        long pendientes = todas.size() - completadas;

        return String.format(" Total: %d |  Completadas: %d |  Pendientes: %d",
                todas.size(), completadas, pendientes);
    }

    public void mostrarConfiguracion() {
        System.out.println("Configuración actual:");
        System.out.println("Nombre de la app: " + nombreApp);
        System.out.println("Máximo de tareas: " + maxTareas);
        System.out.println("Mostrar estadísticas: " + mostrarEstadisticas);
    }

}
