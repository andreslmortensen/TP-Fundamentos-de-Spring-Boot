<h1 align="center">📝 Sistema de Gestión de Tareas</h1>

<p align="center">
  <b>Trabajo Práctico Integrador – Fundamentos de Spring Boot</b><br>
  <i>Ingenieria en Sistemas de Información - Desarrollo de software/i>
</p>

---

## 🎯 Objetivo

Aplicar los **conceptos fundamentales de Spring Boot** para construir una aplicación profesional que gestione tareas (To-Do List), utilizando:

- Inyección de dependencias
- Estereotipos (`@Service`, `@Repository`, `@Component`)
- Configuración mediante `application.properties`
- Profiles (`dev` y `prod`) para diferentes entornos

---

## 🧠 Descripción del Proyecto

El proyecto consiste en un **sistema de gestión de tareas** que permite:

- 📋 Listar tareas existentes  
- ➕ Agregar nuevas tareas  
- ✅ Marcar tareas como completadas  
- 📊 Ver estadísticas de progreso  
- ⚙️ Adaptar comportamiento según el entorno (*desarrollo* o *producción*)

Cada entorno muestra mensajes, límites y configuraciones distintas según el **Profile activo**.

---

## 🧩 Estructura del Proyecto

com.utn.tareas
├── model
│ ├── Tarea.java
│ └── Prioridad.java
├── repository
│ └── TareaRepository.java
├── service
│ ├── TareaService.java
│ ├── MensajeService.java
│ ├── MensajeDevService.java
│ └── MensajeProdService.java
└── TareasApplication.java


---

## ⚙️ Tecnologías Utilizadas

| Tecnología | Versión | Descripción |
|-------------|----------|-------------|
| ☕ Java | 17+ | Lenguaje principal |
| 🧩 Spring Boot | 3.x | Framework para backend |
| ⚙️ Maven | - | Gestión de dependencias |
| ✨ Lombok | - | Reducción de código boilerplate |
| 🔁 Spring Boot DevTools | - | Recarga automática durante desarrollo |

---

## 🚀 Cómo Ejecutar el Proyecto

Ejecutar con MAVEN -> mvn spring-boot:run

### 1️⃣ Clonar el repositorio

git clone https://github.com/usuario/tareas-springboot.git
cd tareas-springboot

🔧 Configuración de Profiles

El comportamiento cambia según el profile activo configurado en:

📄 src/main/resources/application.properties

spring.profiles.active=dev  # o prod

🔹 Entorno DEV

Archivo: application-dev.properties

app.max-tareas=10
app.mostrar-estadisticas=true
logging.level.com.utn.tareas=DEBUG


✅ Mensajes detallados
📊 Estadísticas habilitadas
💻 Límite bajo de tareas

🔸 Entorno PROD

Archivo: application-prod.properties

app.max-tareas=1000
app.mostrar-estadisticas=false
logging.level.com.utn.tareas=ERROR


🚀 Mensajes simples
📉 Sin estadísticas
📈 Límite alto de tareas


## 📸 Capturas de pantalla de la consola con ambos profiles

Perfil de Produccion:
<img width="654" height="555" alt="{41469416-614F-423F-8C4A-FE885E9A9410}" src="https://github.com/user-attachments/assets/448e7180-7a39-459a-b1a4-0e403bf672a3" />

Perfil de Desarrollador:
<img width="646" height="621" alt="{63D8E219-5C16-410B-B428-9B7ECFA0F229}" src="https://github.com/user-attachments/assets/c3ac1d29-6163-4791-8986-702ed5a74d79" />

## Conclusión
A lo largo del desarrollo de este trabajo práctico pude comprender en profundidad cómo funciona el ecosistema de Spring Boot y por qué es tan utilizado en el desarrollo de aplicaciones modernas con Java.
La implementación de la inyección de dependencias me permitió entender la importancia del desacoplamiento entre componentes, y cómo esto mejora la mantenibilidad del código.

Además, la práctica con profiles y configuraciones externas fue muy útil para visualizar cómo un mismo proyecto puede adaptarse fácilmente a diferentes entornos (desarrollo y producción) sin necesidad de modificar el código.

Por último, pude reforzar el uso de anotaciones como @Service, @Repository y @Profile, que aportan claridad y organización al proyecto. En conjunto, este trabajo me ayudó a desarrollar una visión más profesional sobre la estructura y buenas prácticas en aplicaciones Spring Boot.

## 👤 Nombre y legajo
Andrés Lorenzo Mortensen - 50996.
