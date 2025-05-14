# Biblioteca API

Este proyecto es una API para gestionar una biblioteca, que incluye la administración de libros, personas y préstamos de libros. Está construido utilizando Spring Framework y Hibernate.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

- **src/main/java/com/ejemplo/biblioteca**: Contiene el código fuente de la aplicación.
  - **controller**: Controladores que manejan las solicitudes HTTP.
    - `LibroController.java`: Controlador para gestionar libros.
    - `PersonaController.java`: Controlador para gestionar personas.
    - `PrestamoController.java`: Controlador para gestionar préstamos de libros.
  - **model**: Clases que representan las entidades del sistema.
    - `Libro.java`: Entidad que representa un libro.
    - `Persona.java`: Entidad que representa una persona.
    - `Prestamo.java`: Entidad que representa un préstamo.
  - **repository**: Interfaces que extienden JpaRepository para operaciones CRUD.
    - `LibroRepository.java`: Repositorio para la entidad Libro.
    - `PersonaRepository.java`: Repositorio para la entidad Persona.
    - `PrestamoRepository.java`: Repositorio para la entidad Prestamo.
  - **service**: Clases que contienen la lógica de negocio.
    - `LibroService.java`: Servicio para la entidad Libro.
    - `PersonaService.java`: Servicio para la entidad Persona.
    - `PrestamoService.java`: Servicio para la entidad Prestamo.

- **src/main/resources**: Contiene archivos de configuración y documentación.
  - `application.properties`: Configuración de la aplicación.
  - `README.md`: Documentación del proyecto.

- **src/test/java/com/ejemplo/biblioteca**: Contiene pruebas unitarias.
  - `BibliotecaApiApplicationTests.java`: Pruebas para la aplicación.

- **pom.xml**: Archivo de configuración de Maven que define las dependencias y configuraciones del proyecto.

## Requisitos

- Java 11 o superior
- Maven
- Base de datos (configurable en `application.properties`)

## Cómo Ejecutar el Proyecto

1. Clona el repositorio.
2. Navega al directorio del proyecto.
3. Ejecuta el comando `mvn spring-boot:run` para iniciar la aplicación.

## Endpoints

- **Libros**
  - `GET /libros`: Obtener todos los libros.
  - `POST /libros`: Crear un nuevo libro.
  - `GET /libros/{id}`: Obtener un libro específico.
  - `PUT /libros/{id}`: Actualizar un libro.
  - `DELETE /libros/{id}`: Eliminar un libro.

- **Personas**
  - `GET /personas`: Obtener todas las personas.
  - `POST /personas`: Crear una nueva persona.
  - `GET /personas/{id}`: Obtener una persona específica.
  - `PUT /personas/{id}`: Actualizar una persona.
  - `DELETE /personas/{id}`: Eliminar una persona.

- **Préstamos**
  - `POST /prestamos`: Crear un nuevo préstamo.
  - `GET /prestamos/persona/{personaId}`: Obtener préstamos por persona.

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor abre un issue o un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT.