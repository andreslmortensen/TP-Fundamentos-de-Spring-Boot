package com.utn.tareas.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tarea {
    private Long id;
    private String descripcion;
    private boolean completada;
    private Prioridad prioridad;
}
